package com.example.booksearchapp.responses;

import com.example.booksearchapp.entities.Lending;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BookHistoryResponse {
    Date lendingTime;
    BookUserHistoryResponse user;

    public static BookHistoryResponse from(Lending lending){
        BookHistoryResponse bookHistoryResponse = new BookHistoryResponse();
        bookHistoryResponse.setLendingTime(lending.getLendingTime());
        bookHistoryResponse.setUser(BookUserHistoryResponse.from(lending.getUser()));
        return bookHistoryResponse;
    }

    public static List<BookHistoryResponse> from(List<Lending> lendings){
        List<BookHistoryResponse> result = new ArrayList<>();
        for (Lending lending : lendings){
            result.add(BookHistoryResponse.from(lending));
        }
        return result;


    }

}