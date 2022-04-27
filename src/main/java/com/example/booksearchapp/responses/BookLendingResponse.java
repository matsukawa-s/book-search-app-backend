package com.example.booksearchapp.responses;

import com.example.booksearchapp.entities.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookLendingResponse {
    Integer id;
    String name;
    String imagePath;

    public static BookLendingResponse from(Book book){
        BookLendingResponse bookLendingResponse = new BookLendingResponse();
        bookLendingResponse.setId(book.getId());
        bookLendingResponse.setName(book.getName());
        bookLendingResponse.setImagePath(book.getImagePath());
        return bookLendingResponse;
    }
}