package com.springkadai.spring.controller;

import com.springkadai.spring.form.MovieCreateRequest;
import com.springkadai.spring.service.MovieService;
import com.springkadai.spring.entity.Movie;
import com.springkadai.spring.form.MovieUpdateRequest;
import com.springkadai.spring.form.MovieResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie")
    public List<Movie> getMovie(){
        return movieService.getMovies();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable int id) throws NotFoundException {
        return movieService.findById(id);
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieResponse> createMovie(@RequestBody @Valid MovieCreateRequest movieCreateRequest, UriComponentsBuilder uriBuilder){
        Movie movie = movieService.insert(movieCreateRequest.convertToMovie());
        URI uri = uriBuilder.path("/movie/{id}").buildAndExpand(movie.getId()).toUri();
        return ResponseEntity.created(uri).body(new MovieResponse("a new movie is created!"));
    }

    @PatchMapping("/movie/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable int id, @RequestBody MovieUpdateRequest movieUpdateRequest) throws NotFoundException {
            movieService.update(movieUpdateRequest.convertToMovie(id));
            MovieResponse message = new MovieResponse("a movie is update!");
            return ResponseEntity.ok(message);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<MovieResponse> deleteMovie(@PathVariable int id) throws NotFoundException {
        movieService.delete(id);
        MovieResponse message = new MovieResponse("a movie is deleted!");
        return ResponseEntity.ok(message);
    }
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
        NotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
