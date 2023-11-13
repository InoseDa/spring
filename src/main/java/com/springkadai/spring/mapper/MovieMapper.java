package com.springkadai.spring.mapper;

import com.springkadai.spring.entity.Movies;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;;

@Mapper
public interface MovieMapper {

    @Select("SELECT * FROM movies")
    List<Movies> findAll();

    @Select("SELECT * FROM movies WHERE id = #{id}")
    Optional<Movies> findById(int id);

    @Insert("INSERT INTO movies (name,director) VALUES (#{name},#{director}")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(Movies movies);
}
