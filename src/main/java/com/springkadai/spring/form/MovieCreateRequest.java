package com.springkadai.spring.form;

import com.springkadai.spring.entity.Movies;
import jakarta.validation.constraints.NotBlank;

public class MovieCreateRequest {
    @NotBlank
    private final String name;
    @NotBlank
    private final String director;

    public MovieCreateRequest(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public Movies convertToMovie(){
        Movies movies = new Movies(name, director);
        return movies;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }
}
