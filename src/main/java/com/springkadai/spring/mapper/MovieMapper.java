package com.springkadai.spring.mapper;

import com.springkadai.spring.entity.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MovieMapper {

    @Select("SELECT * FROM movies")
    List<Movie> findAll();

    @Select("SELECT * FROM movies WHERE id = #{id}")
    Optional<Movie> findById(int id);

    @Insert("INSERT INTO movies (name,director) VALUES (#{name},#{director})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Movie movie);

    @Update("UPDATE movies SET name=#{name},director=#{director} WHERE id=#{id}")
    void update(Movie movie);

    @Delete("DELETE FROM movies WHERE id =#{id}")
    void delete(int id);
}
