package com.example.booksearchapp.mappers;

import com.example.booksearchapp.entities.Book;
import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.SearchForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    public Book get(Integer id);
    public List<Book> search(SearchForm searchForm);
    public List<Lending> bookHistory(Integer id);
}