package com.example.booksearchapp.controllers;

import com.example.booksearchapp.services.IRequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("requests")
public class RequestController {
    private final IRequestService requestService;

    public RequestController(IRequestService requestService) {
        this.requestService = requestService;
    }

    // 申請中リスト　ユーザー
//    @GetMapping("/requestlist")
//    public List<>

}
