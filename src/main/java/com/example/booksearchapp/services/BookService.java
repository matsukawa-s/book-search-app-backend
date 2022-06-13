package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.Book;
import com.example.booksearchapp.entities.Genre;
import com.example.booksearchapp.entities.Tag;
import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.BorrowForm;
import com.example.booksearchapp.forms.SearchForm;
import com.example.booksearchapp.mappers.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    private final BookMapper bookMapper;
//    private final LendingMapper lendingMapper;
//    private final MyPageMapper myPageMapper;
//    private final GenreMapper genreMapper;
//    private final TagMapper tagMapper;

    public BookService(BookMapper bookMapper
//            , LendingMapper lendingMapper, MyPageMapper myPageMapper, GenreMapper genreMapper, TagMapper tagMapper
    ) {
        this.bookMapper = bookMapper;
//        this.lendingMapper = lendingMapper;
//        this.myPageMapper = myPageMapper;
//        this.genreMapper = genreMapper;
//        this.tagMapper = tagMapper;
    }

    @Override
    public Book get(Integer id) {
        return bookMapper.get(id);
    }

    @Override
    public List<Book> get(SearchForm searchForm) {
        return bookMapper.search(searchForm);
    }
//
//    @Override
//    public Integer borrow(BorrowForm borrowForm) {
//        Integer count = lendingMapper.count(borrowForm);
//        if(count <= 0){
//            return 0;
//        }else{
//            return lendingMapper.borrow(borrowForm);
//        }
//    }
//
//    @Override
//    public Integer returnBook(BorrowForm borrowForm) {
//        return lendingMapper.returnBook(borrowForm);
//    }

//    @Override
//    public List<Lending> lending() {
//        return myPageMapper.lending();
//    }
//
//    @Override
//    public List<Lending> history() {
//        return myPageMapper.history();
//    }

    @Override
    public List<Lending> bookhistory(Integer id) {
        return bookMapper.bookHistory(id);
    }

//    @Override
//    public List<Genre> genreList(){
//        return genreMapper.genreList();
//    }

//    @Override
//    public List<Tag> tagList() {
//        return tagMapper.tagList();
//    }

}