package com.example.booksearchapp.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    Integer id;
    String firstName;
    String lastName;
    String password;
    Integer authority;
    Boolean isDeleted;
}