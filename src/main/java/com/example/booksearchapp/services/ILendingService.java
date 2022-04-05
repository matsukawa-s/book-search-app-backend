package com.example.booksearchapp.services;

import com.example.booksearchapp.forms.BorrowForm;

public interface ILendingService {
    Integer borrow(BorrowForm borrowForm);
    Integer returnBook(BorrowForm borrowForm);
}
