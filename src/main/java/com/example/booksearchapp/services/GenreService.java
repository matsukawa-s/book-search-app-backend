package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.Genre;
import com.example.booksearchapp.mappers.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {
    private final GenreMapper genreMapper;

    public GenreService(GenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }

    @Override
    public List<Genre> genreList(){
        return genreMapper.genreList();
    }
}
