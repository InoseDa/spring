package com.springkadai.spring.form;

import com.springkadai.spring.entity.Movie;

public class MovieUpdateRequest {
    private final String name;
    private final String director;

    public MovieUpdateRequest(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public Movie convertToMovie(int id) {
        Movie movie = new Movie(id, name, director);
        return movie;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }
}
