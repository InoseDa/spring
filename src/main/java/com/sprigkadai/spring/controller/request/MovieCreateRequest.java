package com.sprigkadai.spring.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MovieCreateRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String filmDirector;
    @NotBlank
    private String country;
    @NotNull
    private LocalDate releaseDay;

    public MovieCreateRequest(String title, String filmDirector, String country, LocalDate releaseDay) {
        this.title = title;
        this.filmDirector = filmDirector;
        this.country = country;
        this.releaseDay = releaseDay;
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
