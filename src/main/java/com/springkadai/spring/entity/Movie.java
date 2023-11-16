package com.springkadai.spring.entity;

public class Movie {
    private int id;
    private final String name;
    private final String director;

    public Movie(int id, String name, String director) {
        this.id = id;
        this.name = name;
        this.director = director;
    }

    public Movie(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }
}
