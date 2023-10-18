package com.sprigkadai.spring.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MovieCreateRequest {
    @NotNull
    private int movieId;
    @NotBlank
    private String title;
    @NotBlank
    private String filmDirector;
    @NotBlank
    private String country;
    @NotNull
    private LocalDate releaseDay;

    public MovieCreateRequest(int movieId, String title, String filmDirector, String country, LocalDate releaseDay) {
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
