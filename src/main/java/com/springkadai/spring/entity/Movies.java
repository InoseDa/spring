package com.springkadai.spring.entity;

public class Movies {
    private int id;
    private final String name;
    private final String director;

    public Movies(int id, String name, String director) {
        this.id = id;
        this.name = name;
        this.director = director;
    }

    public Movies(String name, String director) {
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
