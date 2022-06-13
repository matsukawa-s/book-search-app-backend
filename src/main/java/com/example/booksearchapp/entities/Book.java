package com.example.booksearchapp.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter

public class Book {
    Integer id;
    String isbnCode;
    String name;
    Integer number;
    String imagePath;
    String link;
    Boolean isDeleted;
    Date arrivalDate;
    String detail;
    List<Tag> tags;
    List<Genre> genres;
    Integer booksCount;
}