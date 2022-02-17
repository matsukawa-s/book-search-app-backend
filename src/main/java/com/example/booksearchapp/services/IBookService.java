package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.Book;
import com.example.booksearchapp.entities.Category;
import com.example.booksearchapp.entities.Label;
import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.BorrowForm;
import com.example.booksearchapp.forms.SearchForm;
import com.example.booksearchapp.responses.CategoryResponse;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book get(Integer id);
    List<Book> search(SearchForm searchForm);
    Integer borrow(BorrowForm borrowForm);
    Integer returnBook(BorrowForm borrowForm);
    List<Lending> lending();
    List<Lending> history();
    List<Lending> bookhistory(Integer id);
    List<Category> categoryList();
    List<Label> labelList();
}