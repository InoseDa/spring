package com.springkadai.spring.mapper;

import com.springkadai.spring.entity.Movies;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MovieMapper {

    //Read
    @Select("SELECT * FROM movies")
    List<Movies> findAll();

    @Select("SELECT * FROM movies WHERE id = #{id}")
    Optional<Movies> findById(int id);

    //Create
    @Insert("INSERT INTO movies (name,director) VALUES (#{name},#{director})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Movies movies);

    //Update
    @Update("UPDATE movies SET name=#{name},director=#{director} WHERE id=#{id}")
    void update(Movies movies);
}
