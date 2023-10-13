package com.sprigkadai.spring;

public class Movie {
    private int id;
    private String title;
    private String filmDirector;
    private String country;
    private int releaseYear;

    public Movie(int id, String title, String filmDirector, String country, int releaseYear) {
        this.id = id;
        this.title = title;
        this.filmDirector = filmDirector;
        this.country = country;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public String getCountry() {
        return country;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
