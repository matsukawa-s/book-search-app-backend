package com.example.booksearchapp.mappers;

import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.BookReturnForm;
import com.example.booksearchapp.forms.BorrowForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LendingMapper {
    public Integer borrow(BorrowForm borrowForm);
    public Integer returnBook(BookReturnForm borrowForm);
    public Integer count(BorrowForm borrowForm);
}