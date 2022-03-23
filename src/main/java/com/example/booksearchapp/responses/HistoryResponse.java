package com.example.booksearchapp.responses;

import com.example.booksearchapp.entities.Lending;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class HistoryResponse {
    Integer id;
    Date lendingTime;
    Date returnTime;
    BookLendingResponse book;

    public static HistoryResponse from(Lending lending){
        HistoryResponse historyResponse = new HistoryResponse();
        historyResponse.setId(lending.getId());
        historyResponse.setLendingTime(lending.getLendingTime());
        historyResponse.setReturnTime(lending.getReturnTime());
        historyResponse.setBook(BookLendingResponse.from(lending.getBook()));
        return historyResponse;
    }

    public static List<HistoryResponse> from(List<Lending> lendings){
        List<HistoryResponse> result = new ArrayList<>();
        for (Lending lending : lendings){
            result.add(HistoryResponse.from(lending));
        }
        return result;
    }
}