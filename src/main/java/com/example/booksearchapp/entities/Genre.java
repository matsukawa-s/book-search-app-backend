package com.example.booksearchapp.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Genre {
    Integer id;
    String name;
    Boolean isDeleted;
    Integer sortNumber;
}