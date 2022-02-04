package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.Book;
import com.example.booksearchapp.entities.Category;
import com.example.booksearchapp.entities.Label;
import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.SearchForm;
import com.example.booksearchapp.mappers.BookMapper;
import com.example.booksearchapp.mappers.LendingAndBorrowingMapper;
import com.example.booksearchapp.responses.LendingResponse;
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
    public Integer borrow(Integer id) {
        Integer count = lendingAndBorrowingMapper.count(id);
        if(count <= 0){
            return 0;
        }else{
            return lendingAndBorrowingMapper.borrow(id);
        }
    }

    @Override
    public Integer returnBook(Integer id) {
        return lendingAndBorrowingMapper.returnBook(id);
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
    public List<Category> categoryList(){
        return bookMapper.categoryList();
    }

    @Override
    public List<Label> labelList() {
        return bookMapper.labelList();
    }

}