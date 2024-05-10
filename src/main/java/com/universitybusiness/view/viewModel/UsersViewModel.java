package com.universitybusiness.view.viewModel;

import com.universitybusiness.controller.ClientController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

public class UsersViewModel implements ViewModel {
    private final ClientController controller;

    @Getter
    private final DefaultListModel<String> listModel;

    public UsersViewModel(ClientController controller) {
        this.controller = controller;
        listModel = new DefaultListModel<>();
    }

    public DefaultListModel<String> reloadUsersList() {
        listModel.removeAllElements();

        System.out.println("try to reload");
        controller.mock();
        System.out.println("request sent");

//        for (String username : controller.getUserList().values()) {
//            listModel.addElement(username);
//        }

        return listModel;
    }
}
