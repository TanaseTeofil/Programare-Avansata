package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class GenresController {
    private DatabaseConnection databaseConnection;


    public GenresController() {
        try {
            databaseConnection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean create(String name) {
        try {
            String sqlStatement = "INSERT INTO genres(name) values(" + "'" + name + "'" + ")";
            Statement stm = databaseConnection.getConnection().createStatement();
            int rs = stm.executeUpdate(sqlStatement);
            if (rs > 0) {
                System.out.println("Succesfully inserted " + name + " into the database");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public Genres findByName(String name) {
        Genres genres = null;
        try {
            String sqlStatement = "SELECT id, name FROM movies WHERE name = '" + name + "'";
            Statement stm = databaseConnection.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sqlStatement);
            if (rs.next()) {
                genres = new Genres(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return genres;
    }

    public void closeConnection() {
        try {
            databaseConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}