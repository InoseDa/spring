package com.springkadai.spring.service;

import com.springkadai.spring.mapper.MovieMapper;
import com.springkadai.spring.entity.Movies;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieMapper movieMapper;

    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    //Read
    public List<Movies> getMovies(){
        return movieMapper.findAll();
    }

    public Optional<Movies> findById(int id){
        return movieMapper.findById(id);
    }

    //Create
    public Movies insert(Movies movies) {
        movieMapper.insert(movies);
        return movies;
    }

    //Update
    public Movies update(Movies movies) throws NotFoundException {
        Optional<Movies> updateMovie = movieMapper.findById(movies.getId());
        if (updateMovie.isPresent()) {
            movieMapper.update(movies);
        } else {
            throw new NotFoundException("data not found");
        }
        return movies;
    }
}
