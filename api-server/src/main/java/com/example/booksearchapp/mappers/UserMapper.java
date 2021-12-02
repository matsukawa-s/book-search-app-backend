package com.example.booksearchapp.mappers;

import com.example.booksearchapp.entities.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User findByUserName(String userName);
}
