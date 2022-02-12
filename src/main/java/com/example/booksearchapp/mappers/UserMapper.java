package com.example.booksearchapp.mappers;

import com.example.booksearchapp.entities.LoginUser;
import com.example.booksearchapp.forms.SignupForm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public Integer signup(SignupForm signupForm);
    public LoginUser findByUserName(String email);
}