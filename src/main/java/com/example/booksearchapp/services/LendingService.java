package com.example.booksearchapp.services;

import com.example.booksearchapp.forms.BorrowForm;
import com.example.booksearchapp.mappers.LendingMapper;
import org.springframework.stereotype.Service;

@Service
public class LendingService implements ILendingService {
    private final LendingMapper lendingMapper;

    public LendingService(LendingMapper lendingMapper) {
        this.lendingMapper = lendingMapper;
    }
    @Override
    public Integer borrow(BorrowForm borrowForm) {
        Integer count = lendingMapper.count(borrowForm);
        if(count <= 0){
            return 0;
        }else{
            return lendingMapper.borrow(borrowForm);
        }
    }

    @Override
    public Integer returnBook(BorrowForm borrowForm) {
        return lendingMapper.returnBook(borrowForm);
    }

}
