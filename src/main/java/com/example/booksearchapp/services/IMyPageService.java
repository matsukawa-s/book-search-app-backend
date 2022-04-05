package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.Lending;

import java.util.List;

public interface IMyPageService {
    List<Lending> lending();
    List<Lending> history();
}
