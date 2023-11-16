package com.springkadai.spring.service;

import com.springkadai.spring.mapper.MovieMapper;
import com.springkadai.spring.entity.Movie;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieMapper movieMapper;

    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    //Read
    public List<Movie> getMovies(){
        return movieMapper.findAll();
    }

    public Movie findById(int id) throws NotFoundException {
        return movieMapper.findById(id).orElseThrow(() -> new NotFoundException("Movie not found"));
    }

    //Create
    public Movie insert(Movie movie) {
        movieMapper.insert(movie);
        return movie;
    }

    //Update
    public Movie update(Movie movie) throws NotFoundException {
        this.movieMapper.findById(movie.getId()).orElseThrow(() -> new NotFoundException("Movie not found"));
        movieMapper.update(movie);
        return movie;
    }
}
