package com.example.booksearchapp.services;

import com.example.booksearchapp.mappers.RequestMapper;
import org.springframework.stereotype.Service;

@Service
public class RequestService implements IRequestService {
    private final RequestMapper requestMapper;

    public RequestService(RequestMapper requestMapper) {
        this.requestMapper = requestMapper;
    }


}
