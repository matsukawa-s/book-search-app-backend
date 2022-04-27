package com.example.booksearchapp.controllers;

import com.example.booksearchapp.entities.Book;
import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.SearchForm;
import com.example.booksearchapp.responses.*;
import com.example.booksearchapp.services.IBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
/**
 * 本
 */
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 書籍の一件取得
     * @param id
     * @return 本の詳細
     */
    @GetMapping("/{id}")
    public BookResponse get(@PathVariable Integer id) {
        Book book = bookService.get(id);
        return BookResponse.from(book);
    }

    /**
     * 書籍の一覧表示、検索
     * @param searchForm
     * @return 本の一覧
     */
    @GetMapping("")
    public List<BookResponse> get(SearchForm searchForm) {
        List<Book> bookList = bookService.get(searchForm);
        return BookResponse.from(bookList);
    }

    /**
     * 本詳細ページ　貸出履歴
     * @param id
     * @return 表示する本の貸出履歴
     */
    @GetMapping("/bookhistory/{id}")
    public List<BookHistoryResponse> bookhistory(@PathVariable Integer id) {
        List<Lending> lending = bookService.bookhistory(id);
        return BookHistoryResponse.from(lending);
    }
}