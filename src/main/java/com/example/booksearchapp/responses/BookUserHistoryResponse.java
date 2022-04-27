package com.example.booksearchapp.responses;

import com.example.booksearchapp.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUserHistoryResponse {
    String firstName;
    String lastName;

    public static BookUserHistoryResponse from(User user){
        BookUserHistoryResponse bookUserHistoryResponse = new BookUserHistoryResponse();
        bookUserHistoryResponse.setFirstName(user.getFirstName());
        bookUserHistoryResponse.setLastName(user.getLastName());
        return bookUserHistoryResponse;
    }
}