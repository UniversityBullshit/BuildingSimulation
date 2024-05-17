package com.universitybusiness.view.pages;

import com.universitybusiness.controller.ClientController;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.adapters.User;
import com.universitybusiness.view.fabrics.ApplicationViewModelFactory;
import com.universitybusiness.view.viewModel.UsersViewModel;
import com.universitybusiness.view.viewModel.ViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class UsersPage extends Page implements IPage {
    private final String USERNAME_LABEL = "UsernameLabel";
    private final String USERS_LIST = "UsersList";
    private final String DISCONNECT_BUTTON = "DisconnectButton";

    public UsersPage(JFrame frame, WindowManager context) {
        super(frame, context);
    }


    @Override
    public void initializeComponents() {
        components.put(USERNAME_LABEL, new JLabel("Offline"));
        components.put(USERS_LIST, new JList<>(
                context.getViewModelFactory().getUsersViewModel().getListModel())
        );
        components.put(DISCONNECT_BUTTON, new JButton("Disconnect"));

        setupActions();
    }

    @Override
    public void setupAppearance() {
        ((JList<User>) components.get(USERS_LIST)).setCellRenderer(new UserCellRenderer());
    }

    private void setupActions() {
        UsersViewModel viewModel = context.getViewModelFactory().getUsersViewModel();

        context.getViewModelFactory().getUsersViewModel().addUpdateListener(e -> {
            ((JLabel) components.get(USERNAME_LABEL)).setText(viewModel.getUsername());
        });

        ((JList<User>) components.get(USERS_LIST)).setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ((JList<User>) components.get(USERS_LIST)).addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                User user = (User) ((JList) e.getSource()).getSelectedValue();
                if (user != null) {
                    viewModel.setSelectedUser(user);
                    context.showDialog(WindowManager.Pages.USER_PROFILE);
                }
            }
        });
    }

    @Override
    public void draw() {
        // no implementation
    }

    @Override
    public void drawAsDialog(JDialog dialog) {
        dialog.setSize(300, 500);

        JPanel rootPanel = new JPanel(new BorderLayout());
        rootPanel.add(createUsernamePanel(), BorderLayout.NORTH);
        rootPanel.add(components.get(USERS_LIST), BorderLayout.CENTER);
        rootPanel.add(components.get(DISCONNECT_BUTTON), BorderLayout.SOUTH);

        dialog.add(rootPanel);
    }

    private JPanel createUsernamePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(new Insets(10, 5, 15, 0)));
        panel.add(components.get(USERNAME_LABEL));
        return panel;
    }

    class UserCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));

            JLabel label = new JLabel(((User) value).getUsername());
            panel.add(label);

            return panel;
        }
    }
}
