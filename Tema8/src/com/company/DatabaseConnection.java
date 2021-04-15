package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;
    private static DatabaseConnection instance;

    private DatabaseConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "Kcropcps13");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if(instance == null) {
            instance = new DatabaseConnection();
        } else if(instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }



}