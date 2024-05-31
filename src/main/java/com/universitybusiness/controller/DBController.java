package com.universitybusiness.controller;

import com.universitybusiness.model.simulation.Building;
import com.universitybusiness.model.simulation.impl.Habitat;

import java.sql.*;

public class DBController implements IHabitatDBController {

    private Connection connection;

    private final String databasePath = "jdbc:sqlite:database.db";

    private static IHabitatDBController instance;

    private DBController() throws SQLException {
        try {
            connection = DriverManager.getConnection(databasePath);
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static IHabitatDBController getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBController();
        }

        return instance;
    }

    @Override
    public void loadFromDatabase() throws SQLException {
        Habitat habitat = Habitat.getInstance();
        habitat.reset();

        ResultSet result = select();

        while (result.next()) {
            Habitat.restoreBuildingFromDb(
                    result.getLong(1),
                    result.getDouble(2),
                    result.getDouble(3),
                    result.getInt(4),
                    result.getInt(5),
                    result.getLong(6),
                    result.getString(7)
            );
        }

        Habitat.restoreThreads(habitat.getBuildings());
    }

    @Override
    public void saveToDatabase() throws SQLException {
        clearTable();

        Habitat habitat = Habitat.getInstance();

        for (Building building : habitat.getBuildings()) {
            insert(
                    building.getId(),
                    building.getX(),
                    building.getY(),
                    building.getFinishPoint().x,
                    building.getFinishPoint().y,
                    building.getSpawnTime(),
                    building.getClass().getSimpleName()
            );
        }
    }

    private ResultSet select() throws SQLException {
        String query = "SELECT * FROM habitat";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }

    private void insert(
            long id,
            double x,
            double y,
            int finishX,
            int finishY,
            long time,
            String type
    ) throws SQLException {
        PreparedStatement query = connection
                .prepareStatement(
                        "INSERT INTO habitat (id, x, y, finish_x, finish_y, time, type) VALUES (?, ?, ?, ?, ?, ?, ?)"
                );

        query.setLong(1, id);
        query.setDouble(2, x);
        query.setDouble(3, y);
        query.setInt(4, finishX);
        query.setInt(5, finishY);
        query.setLong(6, time);
        query.setString(7, type);

        query.executeUpdate();
    }

    private void clearTable() throws SQLException {
        String query = "DELETE FROM habitat";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    private void createTable() throws SQLException {
        String query = "create table if not exists habitat (" +
                "id     integer not null," +
                "x      real not null," +
                "y      real not null," +
                "finish_x   integer not null," +
                "finish_y   integer not null," +
                "time   integer not null," +
                "type   TEXT not null" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}
