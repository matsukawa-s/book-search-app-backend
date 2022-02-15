package com.example.booksearchapp.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Request {
    Integer id;
    Integer userId;
    String bookName;
    String link;
    String reason;
    Date requestDate;
    Integer status;
}