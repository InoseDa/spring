package com.springkadai.spring.form;

import com.springkadai.spring.entity.Movies;

import java.time.LocalDate;

public class MovieUpdateRequest {
    private final String name;
    private final String director;

    public MovieUpdateRequest(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public Movies convertToMovie(int id) {
        Movies movies = new Movies(id, name, director);
        return movies;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }
}
