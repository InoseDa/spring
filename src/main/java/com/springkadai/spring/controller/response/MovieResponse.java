package com.springkadai.spring.controller.response;

public class MovieResponse {
    private final String message;

    public MovieResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
