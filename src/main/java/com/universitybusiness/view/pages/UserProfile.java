package com.universitybusiness.view.pages;

import com.universitybusiness.controller.ClientController;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.adapters.User;
import com.universitybusiness.view.viewModel.UsersViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserProfile extends Page implements IPage {
    private final String USERNAME_LABEL = "UsernameLabel";
    private final String LOAD_BUTTON = "LoadButton";

    public UserProfile(JFrame frame, WindowManager context) {
        super(frame, context);
    }

    @Override
    public void initializeComponents() {
        components.put(USERNAME_LABEL, new JLabel("Offline"));
        components.put(LOAD_BUTTON, new JButton("Load"));

        setupActions();
    }

    private void setupActions() {
        UsersViewModel viewModel = context.getViewModelFactory().getUsersViewModel();
        ClientController controller = context.getClientController();

        context.getViewModelFactory().getUsersViewModel().addUpdateListener(e -> {
            User user = viewModel.getSelectedUser();

            if (user != null) {
                ((JLabel) components.get(USERNAME_LABEL)).setText(user.getUsername());
            }
        });

        ((JButton) components.get(LOAD_BUTTON)).addActionListener(e -> {
             User user = viewModel.getSelectedUser();

             if (user != null) {
                 controller.loadData(user.getId());
             }
        });
    }

    @Override
    public void setupAppearance() {

    }

    @Override
    public void draw() {

    }

    @Override
    public void drawAsDialog(JDialog dialog) {
        dialog.setSize(300, 200);

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        rootPanel.add(createUsernamePanel());
        rootPanel.add(createControlsPanel());

        dialog.add(rootPanel);
    }

    private JPanel createUsernamePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 5, 15, 0));

        panel.add(components.get(USERNAME_LABEL));

        return panel;
    }

    private JPanel createControlsPanel() {
        JPanel panel = new JPanel();
        panel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        panel.add(components.get(LOAD_BUTTON));

        return panel;
    }
}
