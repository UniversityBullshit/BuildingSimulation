package com.universitybusiness;

import com.universitybusiness.controller.ClientController;
import com.universitybusiness.controller.DBController;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.universitybusiness.controller.HabitatController;
import com.universitybusiness.controller.IHabitatDBController;
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
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Connect to server
        Client client = new Client(8080);

        if (client.isConnected()) {
            Thread clientThread = new Thread(client);
            clientThread.start();
        }

        // Load preferences
        Preferences.getInstance().load();

        SimulationService simulation = new SimulationService(Habitat.getInstance());
        HabitatController habitatController = new HabitatController(simulation);
        IHabitatDBController dbController = DBController.getInstance(); // Change on impl
        ClientController clientController = new ClientController(client, simulation);

        ApplicationViewModelFactory modelFactory = new ApplicationViewModelFactory(
            new SimulationViewModel(habitatController),
            new PreferencesViewModel(Preferences.getInstance()),
            new TerminalViewModel(),
            new UsersViewModel(clientController)
        );

        modelFactory.getUsersViewModel().setUpdating(client.isConnected());

        WindowManager windowManager = new WindowManager(habitatController, clientController, dbController, modelFactory);
        SwingUtilities.invokeLater(() -> windowManager.swapPage(windowManager.getCurrentPage()));
    }
}
