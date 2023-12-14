package com.springkadai.spring.service;

import com.springkadai.spring.entity.Anime;
import com.springkadai.spring.mapper.AnimeMapper;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    private final AnimeMapper animeMapper;

    public AnimeService(AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;
    }

    public List<Anime> getAnime(){
        return animeMapper.findAll();
    }

    public Anime findById(int id) throws NotFoundException {
        return animeMapper.findById(id).orElseThrow(() -> new NotFoundException("Anime not found"));
    }

    public Anime insert(Anime anime) {
        animeMapper.insert(anime);
        return anime;
    }

    public Anime update(Anime anime) throws NotFoundException {
        animeMapper.findById(anime.getId()).orElseThrow(() -> new NotFoundException("Anime not found"));
        animeMapper.update(anime);
        return anime;
    }

    public void delete(int id) throws NotFoundException {
        animeMapper.findById(id).orElseThrow(() -> new NotFoundException("Anime not found"));
        animeMapper.delete(id);
    }
}
