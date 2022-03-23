package com.example.booksearchapp.forms;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class SearchForm {
    String name;
    List<String> tag;
    List<String> genre;
}