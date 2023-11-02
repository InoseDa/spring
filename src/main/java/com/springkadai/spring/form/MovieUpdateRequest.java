package com.springkadai.spring.form;

import java.time.LocalDate;

public class MovieUpdateRequest {
    private final int movieId;
    private final String title;
    private final String filmDirector;
    private final String country;
    private final LocalDate releaseDay;

    public MovieUpdateRequest(int movieId, String title, String filmDirector, String country, LocalDate releaseDay) {
        this.movieId = movieId;
        this.title = title;
        this.filmDirector = filmDirector;
        this.country = country;
        this.releaseDay = releaseDay;
    }

    public int getMovieId() {
        return movieId;
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
