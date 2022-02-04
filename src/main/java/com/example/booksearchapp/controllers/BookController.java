package com.example.booksearchapp.controllers;

import com.example.booksearchapp.entities.Book;
import com.example.booksearchapp.entities.Category;
import com.example.booksearchapp.entities.Label;
import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.SearchForm;
import com.example.booksearchapp.responses.*;
import com.example.booksearchapp.services.IBookService;
import org.springframework.web.bind.annotation.*;

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
    public Integer borrow(Integer id) {
        Integer lending = bookService.borrow(id);
        return lending;
    }

    // 返す
    @PostMapping("/return")
    @ResponseBody
    public Integer returnBook(Integer id) {
        Integer lending = bookService.returnBook(id);
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
    @GetMapping("/categories")
    public List<CategoryResponse> categoryList() {
        List<Category> categoryList = bookService.categoryList();
        return CategoryResponse.from(categoryList);
    }

    // ラベル一覧
    @GetMapping("/labels")
    public List<LabelResponse> labelList() {
        List<Label> labelList = bookService.labelList();
        return LabelResponse.from(labelList);
    }
}