package com.springkadai.spring.controller;

import com.springkadai.spring.form.MovieCreateRequest;
import com.springkadai.spring.service.MovieService;
import com.springkadai.spring.entity.Movies;
import com.springkadai.spring.form.MovieUpdateRequest;
import com.springkadai.spring.form.MovieResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie")
    public List<Movies> getMovie(){
        return movieService.getMovies();
    }

    @GetMapping("/movie/{id}")
    public Optional<Movies> getMovieById(@PathVariable int id){
        return movieService.findById(id);
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieResponse> createMovie(@RequestBody @Valid MovieCreateRequest movieCreateRequest, UriComponentsBuilder uriBuilder){
        Movies movies = movieService.insert(movieCreateRequest.convertToMovie());
        URI uri = uriBuilder.path("/movie/{id}").buildAndExpand(movies.getId()).toUri();
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
