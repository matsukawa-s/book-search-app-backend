package com.example.booksearchapp.controllers;

import com.example.booksearchapp.forms.BookReturnForm;
import com.example.booksearchapp.forms.BorrowForm;
import com.example.booksearchapp.services.ILendingService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
/**
 *  本の貸し借り
 */
public class LendingController {
    private final ILendingService lendingService;

    public LendingController(ILendingService lendingService){
        this.lendingService = lendingService;
    }

    /**
     * 本を借りる
     * @param borrowForm
     * @param userId
     * @return
     */
    @PostMapping("/borrow")
    @ResponseBody
    public Integer borrow(@RequestBody BorrowForm borrowForm, @AuthenticationPrincipal final String userId) {
        borrowForm.setUserId(userId);
        Integer lending = lendingService.borrow(borrowForm);

        return lending;
    }

    /**
     * 本を返す
     * @param borrowForm
     * @return
     */
    @PostMapping("/return")
    @ResponseBody
    public Integer returnBook(@RequestBody BookReturnForm borrowForm) {
        Integer lending = lendingService.returnBook(borrowForm);

        return lending;
    }
}