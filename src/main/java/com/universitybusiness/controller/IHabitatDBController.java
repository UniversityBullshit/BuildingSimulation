package com.universitybusiness.controller;

import com.universitybusiness.model.simulation.BuildingType;

import java.sql.SQLException;

public interface IHabitatDBController {
    void loadFromDatabase() throws SQLException;
    void saveToDatabase() throws SQLException;
    void loadFromDatabase(BuildingType type) throws SQLException;
    void saveToDatabase(BuildingType type) throws SQLException;
}
