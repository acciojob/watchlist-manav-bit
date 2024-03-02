package com.driver;


import org.springframework.stereotype.Repository;

@Repository
public class Movie {
    private String name;
    private String director;
    private int releaseYear;
    private double duration;

    public Movie(String name, String director, int releaseYear, double duration) {
        this.name = name;
        this.director = director;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
