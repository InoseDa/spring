package com.springkadai.spring.controller;

import com.springkadai.spring.entity.Anime;
import com.springkadai.spring.form.AnimeCreateRequest;
import com.springkadai.spring.service.AnimeService;
import com.springkadai.spring.form.AnimeUpdateRequest;
import com.springkadai.spring.form.AnimeResponse;
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
public class AnimeController {
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/anime")
    public List<Anime> getAnime(){
        return animeService.getAnime();
    }

    @GetMapping("/anime/{id}")
    public Anime getAnimeById(@PathVariable int id) throws NotFoundException {
        return animeService.findById(id);
    }

    @PostMapping("/anime")
    public ResponseEntity<AnimeResponse> createAnime(@RequestBody @Valid AnimeCreateRequest animeCreateRequest, UriComponentsBuilder uriBuilder){
        Anime anime = animeService.insert(animeCreateRequest.convertToAnime());
        URI uri = uriBuilder.path("/anime/{id}").buildAndExpand(anime.getId()).toUri();
        return ResponseEntity.created(uri).body(new AnimeResponse("a new anime is created!"));
    }

    @PatchMapping("/anime/{id}")
    public ResponseEntity<AnimeResponse> updateAnime(@PathVariable int id, @RequestBody AnimeUpdateRequest animeUpdateRequest) throws NotFoundException {
            animeService.update(animeUpdateRequest.ConvertToAnime(id));
            AnimeResponse message = new AnimeResponse("anime is update!");
            return ResponseEntity.ok(message);
    }

    @DeleteMapping("/anime/{id}")
    public ResponseEntity<AnimeResponse> deleteMovie(@PathVariable int id) throws NotFoundException {
        animeService.delete(id);
        AnimeResponse message = new AnimeResponse("anime is deleted!");
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
