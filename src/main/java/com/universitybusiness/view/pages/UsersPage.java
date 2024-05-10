package com.universitybusiness.view.pages;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.fabrics.ApplicationViewModelFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
        components.put(USERS_LIST, new JList(
                context.getViewModelFactory().getUsersViewModel().getListModel())
        );
        components.put(DISCONNECT_BUTTON, new JButton("Disconnect"));

        setupActions();
    }

    @Override
    public void reset() {
        super.reset();

        ((JLabel) components.get(USERNAME_LABEL)).setText(
            context.getClientController().getUsername()
        );

        context.getViewModelFactory().getUsersViewModel().reloadUsersList();
    }

    @Override
    public void setupAppearance() {
        ((JList<?>) components.get(USERS_LIST)).setCellRenderer(new UserListRenderer());
    }

    private void setupActions() {
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

    static class UserListRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList<?> list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setText(value.toString());

            JButton button = new JButton("Load");

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
            panel.add(label);
            panel.add(button);
            return panel;
        }
    }
}
