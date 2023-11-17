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

    public List<Movie> getMovies(){
        return movieMapper.findAll();
    }

    public Movie findById(int id) throws NotFoundException {
        return movieMapper.findById(id).orElseThrow(() -> new NotFoundException("Movie not found"));
    }

    public Movie insert(Movie movie) {
        movieMapper.insert(movie);
        return movie;
    }

    public Movie update(Movie movie) throws NotFoundException {
        movieMapper.findById(movie.getId()).orElseThrow(() -> new NotFoundException("Movie not found"));
        movieMapper.update(movie);
        return movie;
    }

    public void delete(int id) throws NotFoundException {
        movieMapper.findById(id).orElseThrow(() -> new NotFoundException("Movie not found"));
        movieMapper.delete(id);
    }
}
