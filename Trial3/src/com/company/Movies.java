package com.company;


public class Movies  {
    private int id;
    private String title;
    private int release_date;
    private int duration;
    private int score;

    public Movies(int id, String title, int release_date, int duration, int score) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.duration = duration;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease_date() {
        return release_date;
    }

    public void setRelease_date(int release_date) {
        this.release_date = release_date;
    }
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}