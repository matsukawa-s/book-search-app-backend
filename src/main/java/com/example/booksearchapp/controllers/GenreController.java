package com.example.booksearchapp.controllers;

import com.example.booksearchapp.entities.Genre;
import com.example.booksearchapp.responses.GenreResponse;
import com.example.booksearchapp.services.IBookService;
import com.example.booksearchapp.services.IGenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController{
    private final IGenreService genreService;

    public GenreController(IGenreService genreService) {
        this.genreService = genreService;
    }

    /**
     * ジャンルの取得
     * @return ジャンル一覧
     */
    @GetMapping("")
    public List<GenreResponse> genreList() {
        List<Genre> genreList = genreService.genreList();
        return GenreResponse.from(genreList);
    }
}