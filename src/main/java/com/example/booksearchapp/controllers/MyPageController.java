package com.example.booksearchapp.controllers;

import com.example.booksearchapp.entities.Lending;
import com.example.booksearchapp.responses.HistoryResponse;
import com.example.booksearchapp.responses.LendingResponse;
import com.example.booksearchapp.services.IBookService;
import com.example.booksearchapp.services.IMyPageService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mypage")
public class MyPageController {
    private final IMyPageService myPageService;

    public MyPageController(IMyPageService myPageService) {
        this.myPageService = myPageService;
    }

    /**
     * 利用状況
     * @param userId
     * @return 現在借りている本の一覧
     */
    @GetMapping("/lending")
    public List<LendingResponse> lending(@AuthenticationPrincipal final String userId) {
        List<Lending> lending = myPageService.lending(userId);
        return LendingResponse.from(lending);
    }

    /**
     * 貸出履歴
     * @param userId
     * @return 今まで借りた本の一覧
     */
    @GetMapping("/history")
    public List<HistoryResponse> history(@AuthenticationPrincipal final String userId) {
        List<Lending> lending = myPageService.history(userId);
        return HistoryResponse.from(lending);
    }
}
