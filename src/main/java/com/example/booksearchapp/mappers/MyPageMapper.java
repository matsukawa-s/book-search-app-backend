package com.example.booksearchapp.mappers;

import com.example.booksearchapp.entities.Lending;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyPageMapper {
    public List<Lending> lending();
    public List<Lending> history();
}
