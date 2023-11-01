package com.springkadai.spring.entity;

public class Movies {
    private int id;
    private String name;
    private String director;

    public Movies(int id, String name, String director) {
        this.id = id;
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
