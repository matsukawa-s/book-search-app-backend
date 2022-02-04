package com.example.booksearchapp.mappers;

import com.example.booksearchapp.entities.Lending;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LendingAndBorrowingMapper {
    public Integer borrow(Integer id);
    public Integer returnBook(Integer id);
    public List<Lending> lending();
    public List<Lending> history();
    public Integer count(Integer id);
    public List<Lending> bookHistory(Integer id);
}