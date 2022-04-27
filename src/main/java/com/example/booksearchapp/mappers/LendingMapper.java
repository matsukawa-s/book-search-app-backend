package com.example.booksearchapp.mappers;

import com.example.booksearchapp.forms.BorrowForm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LendingMapper {
    public Integer borrow(BorrowForm borrowForm);
    public Integer returnBook(BorrowForm borrowForm);
    public Integer count(BorrowForm borrowForm);
}