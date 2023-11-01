package com.springkadai.spring.controller;

import com.springkadai.spring.service.MovieService;
import com.springkadai.spring.entity.Movies;
import com.springkadai.spring.form.MovieCreateRequest;
import com.springkadai.spring.form.MovieUpdateRequest;
import com.springkadai.spring.form.MovieResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie")
    public List<Movies> getMovie(){
        List<Movies> movies = movieService.getMovies();
        return movies;
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieResponse> createMovie(@RequestBody @Valid MovieCreateRequest movieCreateRequest, UriComponentsBuilder uriComponentsBuilder){
        URI uri = uriComponentsBuilder.path("/movie/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(new MovieResponse("a new movie is created!"));
    }

    @PatchMapping("/movie/{id}")
    public MovieResponse updateMovie(@PathVariable int id, @RequestBody MovieUpdateRequest movieUpdateRequest){
        return new MovieResponse("a movie is update!");
    }

    @DeleteMapping("/movie/{id}")
    public MovieResponse deleteMovie(@PathVariable int id, @RequestBody MovieUpdateRequest movieDeleteRequest){
        return new MovieResponse("a movie is deleted!");
    }
}
