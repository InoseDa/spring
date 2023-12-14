package com.springkadai.spring.form;

import com.springkadai.spring.entity.Anime;

public class AnimeUpdateRequest {
    private final String title;
    private final String original_writer;

    public AnimeUpdateRequest(String title, String original_writer) {
        this.title = title;
        this.original_writer = original_writer;
    }

    public Anime ConvertToAnime(int id) {
        Anime anime = new Anime(id, title, original_writer);
        return anime;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginal_writer() {
        return original_writer;
    }
}
