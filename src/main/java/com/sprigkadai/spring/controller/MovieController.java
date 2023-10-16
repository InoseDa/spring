package com.sprigkadai.spring.controller;

import com.sprigkadai.spring.controller.request.MovieCreateRequest;
import com.sprigkadai.spring.controller.request.MovieUpdateRequest;
import com.sprigkadai.spring.controller.response.MovieResponse;
import com.sprigkadai.spring.controller.response.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class MovieController {

    @GetMapping("/movie")
    public List<Movie> getMovie(){
        List<Movie> movies = List.of(
                new Movie(1,"鬼滅の刃 無限列車編", "外崎春雄", "日本", LocalDate.of(2020,10,16),
                new Movie(2,"千と千尋の神隠し", "宮崎駿", "日本", LocalDate.of(2001,07,20),
                new Movie(3,"タイタニック", "ジェームズ・キャメロン", "アメリカ", LocalDate.of(1997,12,20)
        );
        return movies;
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieResponse> createMovie(@RequestBody MovieCreateRequest movieCreateRequest, UriComponentsBuilder uriComponentsBuilder){
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
