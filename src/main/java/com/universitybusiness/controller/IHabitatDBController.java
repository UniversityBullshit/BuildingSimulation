package com.universitybusiness.controller;

import java.sql.SQLException;

public interface IHabitatDBController {
    void loadFromDatabase() throws SQLException;
    void saveToDatabase() throws SQLException;
}
