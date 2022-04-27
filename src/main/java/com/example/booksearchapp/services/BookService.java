package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.Book;
import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.SearchForm;
import com.example.booksearchapp.mappers.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Book get(Integer id) {
        return bookMapper.get(id);
    }

    @Override
    public List<Book> get(SearchForm searchForm) {
        return bookMapper.search(searchForm);
    }

    @Override
    public List<Lending> bookhistory(Integer id) {
        return bookMapper.bookHistory(id);
    }
}