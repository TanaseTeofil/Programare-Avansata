package com.company;

public class Main {

    public static void main(String[] args) {
        MoviesController MoviesController = new MoviesController();
        GenresController GenresController = new GenresController();

        insertRows(GenresController, MoviesController);
        findData(GenresController, MoviesController);

        MoviesController.closeConnection();
        GenresController.closeConnection();
    }

    private static void insertRows(GenresController GenresController, MoviesController MoviesController) {

        String[] Movies = {"Captain America", "Haunting of Hill House", "Blacklist", "Starwars", "Split"};
        int[] release_date = {1982, 1980, 1975, 2017, 2018};
        int[] duration = {124, 60, 60, 156, 123};
        int[] score = {6, 9, 8, 7, 5};
        String[] Genres = {"Action", "Horror", "Detective", "SF", "Action"};

        for (int i = 0; i < release_date.length; i++) {
            MoviesController.create(Movies[i], release_date[i], duration[i], score[i]);
            Movies movies = MoviesController.findByTitle(Movies[i]);
            GenresController.create(Genres[i]);
        }
    }

    private static void findData(GenresController GenresController, MoviesController MoviesController) {
        Movies movies;
        Genres genres;
        String[] Movies = {"Captain America", "Haunting of Hill House", "Blacklist", "Starwars", "Split"};

        for (String MoviesName : Movies) {
            movies = MoviesController.findByTitle(MoviesName);
            genres = GenresController.findByName(movies.getTitle());
            printInfo(genres, movies);
        }
    }


    private static void printInfo(Genres Genres, Movies Movies) {
        System.out.println(Movies.getTitle() + " - " + Movies.getRelease_date() + " - " + Movies.getDuration() + " - " + Movies.getScore());
        System.out.println(Genres.getName());
    }
}