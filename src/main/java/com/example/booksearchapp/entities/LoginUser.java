package com.example.booksearchapp.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {
    Long id;
    String email;
    String firstName;
    String lastName;
    String password;
    Integer authority;
}
