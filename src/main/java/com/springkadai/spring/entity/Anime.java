package com.springkadai.spring.entity;

public class Anime {
    private int id;
    private final String title;
    private final String original_writer;

    public Anime(int id, String title, String original_writer) {
        this.id = id;
        this.title = title;
        this.original_writer = original_writer;
    }

    public Anime(String title, String original_writer) {
        this.title = title;
        this.original_writer = original_writer;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginal_writer() {
        return original_writer;
    }
}
