package com.springkadai.spring.controller;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieMapper movieMapper;

    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public List<Movies> getMovies(){
        List<Movies> movies = movieMapper.findAll();
        return movies;
    }
}
