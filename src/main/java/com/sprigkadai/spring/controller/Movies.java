package com.sprigkadai.spring.controller;

public class Movies {
    private int id;
    private String name;

    public Movies(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
