package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.mappers.MyPageMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPageService implements IMyPageService {
    private final MyPageMapper myPageMapper;

    public MyPageService(MyPageMapper myPageMapper) {
        this.myPageMapper = myPageMapper;
    }
    @Override
    public List<Lending> lending() {
        return myPageMapper.lending();
    }

    @Override
    public List<Lending> history() {
        return myPageMapper.history();
    }
}
