package com.example.booksearchapp.responses;

import com.example.booksearchapp.entities.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class GenreResponse {
    Integer id;
    String name;

    public static GenreResponse from(Genre genre){
        GenreResponse genreResponse = new GenreResponse();
        genreResponse.setId(genre.getId());
        genreResponse.setName(genre.getName());
        return genreResponse;
    }

    public static List<GenreResponse> from(List<Genre> genres){
        List<GenreResponse> result = new ArrayList<>();
        for (Genre genre : genres){
            result.add(GenreResponse.from(genre));
        }
        return result;
    }
}