package com.springkadai.spring.form;

import com.springkadai.spring.entity.Anime;
import jakarta.validation.constraints.NotBlank;

public class AnimeCreateRequest {
    @NotBlank
    private final String title;
    @NotBlank
    private final String original_writer;

    public AnimeCreateRequest(String title, String original_writer) {
        this.title = title;
        this.original_writer = original_writer;
    }

    public Anime convertToAnime(){
        Anime anime = new Anime(title, original_writer);
        return anime;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginal_writer() {
        return original_writer;
    }
}
