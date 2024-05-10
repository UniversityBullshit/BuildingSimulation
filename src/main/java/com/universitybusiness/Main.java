package com.universitybusiness;

import com.universitybusiness.controller.ClientController;
import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.model.client.Client;
import com.universitybusiness.model.simulation.impl.Habitat;
import com.universitybusiness.model.Preferences;
import com.universitybusiness.service.SimulationService;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.fabrics.ApplicationViewModelFactory;
import com.universitybusiness.view.viewModel.PreferencesViewModel;
import com.universitybusiness.view.viewModel.SimulationViewModel;
import com.universitybusiness.view.viewModel.TerminalViewModel;
import com.universitybusiness.view.viewModel.UsersViewModel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Connect to server
        Client client = new Client(8080);
        Thread clientThread = new Thread(client);
        clientThread.start();

        // Load preferences
        Preferences.getInstance().load();

        SimulationService simulation = new SimulationService(Habitat.getInstance());
        HabitatController habitatController = new HabitatController(simulation);
        ClientController clientController = new ClientController(client);

        ApplicationViewModelFactory modelFactory = new ApplicationViewModelFactory(
            new SimulationViewModel(habitatController),
            new PreferencesViewModel(Preferences.getInstance()),
            new TerminalViewModel(),
            new UsersViewModel(clientController)
        );

        WindowManager windowManager = new WindowManager(habitatController, clientController ,modelFactory);
        SwingUtilities.invokeLater(() -> windowManager.swapPage(windowManager.getCurrentPage()));

        windowManager.getMainFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Preferences.getInstance().save();
                clientController.disconnect();
                System.exit(0);
            }
        });
    }

    private static void testServer() {
        try {
            Socket clientSocket = new Socket("localhost", 8080);

            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            long id = in.readLong();
            System.out.println("Client connected: " + id);

            out.writeObject("loadData");
            out.writeLong(id);
            out.flush();

            String response = (String) in.readObject();
            System.out.println(response);

            out.writeObject("disconnect");
            out.flush();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
