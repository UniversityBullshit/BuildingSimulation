package com.universitybusiness.controller;

import com.universitybusiness.model.simulation.BuildingType;

import java.sql.SQLException;

public interface IHabitatDBController {
    void loadFromDatabase() throws SQLException;
    void saveToDatabase() throws SQLException;
    void loadBuildings(BuildingType type) throws SQLException;
    void saveBuildings(BuildingType type) throws SQLException;
}
