package com.example.booksearchapp.responses;

import com.example.booksearchapp.entities.Request;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RequestResponse {
    Integer id;
    Integer userId;
    String bookName;
    Date requestDate;
    Integer status;

    public static RequestResponse from(Request request){
        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setId(request.getId());
        requestResponse.setUserId(request.getUserId());
        requestResponse.setBookName(request.getBookName());
        requestResponse.setRequestDate(request.getRequestDate());
        requestResponse.setStatus(request.getStatus());
        return requestResponse;
    }

    public static List<RequestResponse> from(List<Request> requests){
        List<RequestResponse> result = new ArrayList<>();
        for (Request request : requests) {
            result.add(RequestResponse.from(request));
        }
        return result;
    }
}
