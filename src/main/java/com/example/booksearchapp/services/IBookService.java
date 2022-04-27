package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.Book;
import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.SearchForm;

import java.util.List;

public interface IBookService {
    Book get(Integer id);
    List<Book> get(SearchForm searchForm);
    List<Lending> bookhistory(Integer id);
}