package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.Book;
import com.example.booksearchapp.entities.Genre;
import com.example.booksearchapp.entities.Tag;
import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.BorrowForm;
import com.example.booksearchapp.forms.SearchForm;
import com.example.booksearchapp.mappers.BookMapper;
import com.example.booksearchapp.mappers.LendingAndBorrowingMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    private final BookMapper bookMapper;
    private final LendingAndBorrowingMapper lendingAndBorrowingMapper;

    public BookService(BookMapper bookMapper, LendingAndBorrowingMapper lendingAndBorrowingMapper) {
        this.bookMapper = bookMapper;
        this.lendingAndBorrowingMapper = lendingAndBorrowingMapper;
    }

    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public Book get(Integer id) {
        return bookMapper.get(id);
    }

    @Override
    public List<Book> search(SearchForm searchForm) {
        return bookMapper.search(searchForm);
    }

    @Override
    public Integer borrow(BorrowForm borrowForm) {
        Integer count = lendingAndBorrowingMapper.count(borrowForm);
        if(count <= 0){
            return 0;
        }else{
            return lendingAndBorrowingMapper.borrow(borrowForm);
        }
    }

    @Override
    public Integer returnBook(BorrowForm borrowForm) {
        return lendingAndBorrowingMapper.returnBook(borrowForm);
    }

    @Override
    public List<Lending> lending() {
        return lendingAndBorrowingMapper.lending();
    }

    @Override
    public List<Lending> history() {
        return lendingAndBorrowingMapper.history();
    }

    @Override
    public List<Lending> bookhistory(Integer id) {
        return lendingAndBorrowingMapper.bookHistory(id);
    }

    @Override
    public List<Genre> genreList(){
        return bookMapper.genreList();
    }

    @Override
    public List<Tag> tagList() {
        return bookMapper.tagList();
    }

}