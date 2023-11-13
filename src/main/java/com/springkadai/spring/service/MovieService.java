package com.springkadai.spring.service;

import com.springkadai.spring.mapper.MovieMapper;
import com.springkadai.spring.entity.Movies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieMapper movieMapper;

    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public List<Movies> getMovies(){
        return movieMapper.findAll();
    }

    public Optional<Movies> findById(int id){
        return movieMapper.findById(id);
    }

    public Movies insert(Movies movies) {
        movieMapper.insert(movies);
        return movies;
    }
}
