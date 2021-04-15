package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MoviesController {
    private DatabaseConnection databaseConnection;

    public MoviesController() {
        try {
            databaseConnection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean create(String title, int release_date, int duration, int score) {
        try {
            String sqlStatement = "INSERT INTO movies(title, release_date, duration, score) values(" + "'" + title + "'" + "," + release_date + "," + duration + "," + score + ")";
            Statement stm = databaseConnection.getConnection().createStatement();

            int rs = stm.executeUpdate(sqlStatement);
            if(rs > 0) {
                System.out.println("Succesfully inserted movie " + title + " into the database");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public Movies findByTitle(String title) {
        Movies movies = null;
        try {
            String sqlStatement = "SELECT id, title, release_date, duration, score FROM movies WHERE title = '" + title + "'";
            Statement stm = databaseConnection.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sqlStatement);
            if(rs.next()) {
                movies = new Movies(rs.getInt("id"), rs.getString("title"), rs.getInt("release_date"), rs.getInt("duration"), rs.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return movies;
    }

    public void closeConnection() {
        try {
            databaseConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}