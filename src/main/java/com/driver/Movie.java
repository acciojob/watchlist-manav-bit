package com.driver;


import org.springframework.stereotype.Repository;

@Repository
public class Movie {
    private String name;
    private String director;
    private int releaseYear;
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
