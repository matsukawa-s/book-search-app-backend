package com.example.booksearchapp.mappers;

import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.forms.BorrowForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LendingAndBorrowingMapper {
    public Integer borrow(BorrowForm borrowForm);
    public Integer returnBook(BorrowForm borrowForm);
    public List<Lending> lending();
    public List<Lending> history();
    public Integer count(BorrowForm borrowForm);
    public List<Lending> bookHistory(Integer id);
}