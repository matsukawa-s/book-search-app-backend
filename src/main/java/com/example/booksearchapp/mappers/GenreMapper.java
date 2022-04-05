package com.example.booksearchapp.mappers;

import com.example.booksearchapp.entities.Genre;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenreMapper {
    public List<Genre> genreList();
}
