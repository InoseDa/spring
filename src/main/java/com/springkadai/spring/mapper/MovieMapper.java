package com.springkadai.spring.mapper;

import com.springkadai.spring.entity.Movies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper {

    @Select("SELECT * FROM movies")
    List<Movies> findAll();
}
