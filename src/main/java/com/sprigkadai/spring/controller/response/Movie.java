package com.sprigkadai.spring.controller.response;

import java.time.LocalDate;

public class Movie {
    private final int id;
    private final String title;
    private final String filmDirector;
    private final String country;
    private final LocalDate releaseDay;

    public Movie(int id, String title, String filmDirector, String country, LocalDate releaseDay) {
        this.id = id;
        this.title = title;
        this.filmDirector = filmDirector;
        this.country = country;
        this.releaseDay = releaseDay;
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

    public LocalDate getReleaseDay() {
        return releaseDay;
    }
}
