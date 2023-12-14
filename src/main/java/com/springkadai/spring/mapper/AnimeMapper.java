package com.springkadai.spring.mapper;

import com.springkadai.spring.entity.Anime;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AnimeMapper {

    @Select("SELECT * FROM anime")
    List<Anime> findAll();

    @Select("SELECT * FROM anime WHERE id = #{id}")
    Optional<Anime> findById(int id);

    @Insert("INSERT INTO anime (title,original_writer) VALUES (#{title},#{original_writer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Anime anime);

    @Update("UPDATE anime SET title=#{title},original_writer=#{original_writer} WHERE id=#{id}")
    void update(Anime anime);

    @Delete("DELETE FROM anime WHERE id =#{id}")
    void delete(int id);
}
