package com.example.booksearchapp.responses;

import com.example.booksearchapp.entities.Lending;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class LendingResponse {
    Integer id;
    Date lendingTime;
    BookLendingResponse book;

    public static LendingResponse from(Lending lending){
        LendingResponse lendingResponse = new LendingResponse();
        lendingResponse.setId(lending.getId());
        lendingResponse.setLendingTime(lending.getLendingTime());
        lendingResponse.setBook(BookLendingResponse.from(lending.getBook()));
        return lendingResponse;
    }

    public static List<LendingResponse> from(List<Lending> lendings){
        List<LendingResponse> result = new ArrayList<>();
        for (Lending lending : lendings){
            result.add(LendingResponse.from(lending));
        }
        return result;
    }
}