package com.sprigkadai.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/movie")
    public List<Movie> movies(){
        List<Movie> movies = List.of(
                new Movie(1,"鬼滅の刃 無限列車編", "外崎春雄", "日本", 2020),
                new Movie(2,"千と千尋の神隠し", "宮崎駿", "日本", 2001),
                new Movie(3,"タイタニック", "ジェームズ・キャメロン", "アメリカ", 1997)
        );
        return movies;
    }
}
