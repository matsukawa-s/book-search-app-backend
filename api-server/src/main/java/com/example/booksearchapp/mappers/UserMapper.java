package com.example.booksearchapp.mappers;

import com.example.booksearchapp.entities.LoginUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public LoginUser findByUserName(String email);
}
