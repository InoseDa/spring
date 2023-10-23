package com.sprigkadai.spring.controller;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper {

    @Select("SELECT name FROM movies")
    List<Movies> findAll();
}
