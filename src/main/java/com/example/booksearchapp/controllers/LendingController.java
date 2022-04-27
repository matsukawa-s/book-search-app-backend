package com.example.booksearchapp.controllers;

import com.example.booksearchapp.forms.BorrowForm;
import com.example.booksearchapp.services.ILendingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lendings")
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
     * @return
     */
    @PostMapping("/borrow")
    @ResponseBody
    public Integer borrow(@RequestBody BorrowForm borrowForm) {
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
    public Integer returnBook(@RequestBody BorrowForm borrowForm) {
        Integer lending = lendingService.returnBook(borrowForm);
        return lending;
    }
}