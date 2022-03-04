package com.example.booksearchapp.controllers;

import com.example.booksearchapp.entities.Book;
import com.example.booksearchapp.entities.Genre;
import com.example.booksearchapp.entities.Tag;
import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.BorrowForm;
import com.example.booksearchapp.forms.SearchForm;
import com.example.booksearchapp.responses.*;
import com.example.booksearchapp.services.IBookService;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    // 書籍の一覧取得
    @GetMapping("")
    public List<BookResponse> findAll() {
        List<Book> bookList = bookService.findAll();
        return BookResponse.from(bookList);
    }

    // 書籍の一件取得
    @GetMapping("/{id}")
    public BookResponse get(@PathVariable Integer id) {
        Book book = bookService.get(id);
        return BookResponse.from(book);
    }

    // 書籍の検索
    @GetMapping("/search")
    public List<BookResponse> search(SearchForm searchForm) {
        List<Book> bookList = bookService.search(searchForm);
        return BookResponse.from(bookList);
    }

    // 借りる
    @PostMapping("/borrow")
    @ResponseBody
    public Integer borrow(@RequestBody BorrowForm borrowForm) {
        Integer lending = bookService.borrow(borrowForm);
        return lending;
    }

    // 返す
    @PostMapping("/return")
    @ResponseBody
    public Integer returnBook(@RequestBody BorrowForm borrowForm) {
        Integer lending = bookService.returnBook(borrowForm);
        return lending;
    }

    // マイページ　貸出中
    @GetMapping("/lending")
    public List<LendingResponse> lending() {
        List<Lending> lending = bookService.lending();
        return LendingResponse.from(lending);
    }

    // マイページ　貸出履歴
    @GetMapping("/history")
    public List<HistoryResponse> history() {
        List<Lending> lending = bookService.history();
        return HistoryResponse.from(lending);
    }

    // 本詳細ページ　貸出履歴
    @GetMapping("/bookhistory/{id}")
    public List<BookHistoryResponse> bookhistory(@PathVariable Integer id) {
        List<Lending> lending = bookService.bookhistory(id);
        return BookHistoryResponse.from(lending);
    }

    // カテゴリ一覧
    @GetMapping("/genres")
    public List<GenreResponse> genreList() {
        List<Genre> genreList = bookService.genreList();
        return GenreResponse.from(genreList);
    }

    // ラベル一覧
    @GetMapping("/tags")
    public List<TagResponse> tagList() {
        List<Tag> tagList = bookService.tagList();
        return TagResponse.from(tagList);
    }
}