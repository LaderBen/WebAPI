package com.antra.webapi.dao.impl;

import com.antra.webapi.dao.TransactionRepository;
import com.antra.webapi.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
    private static List<Transaction> mockTransactionData;

    static {
        mockTransactionData = new ArrayList<>();
        mockTransactionData.add(new Transaction(1, 20, new Date(2023, Calendar.JANUARY, 12)));
        mockTransactionData.add(new Transaction(2, 120, new Date(2023, Calendar.FEBRUARY, 12)));
        mockTransactionData.add(new Transaction(1, 50, new Date(2023, Calendar.FEBRUARY, 12)));
        mockTransactionData.add(new Transaction(1, 150, new Date(2023, Calendar.MARCH, 12)));
        mockTransactionData.add(new Transaction(3, 80, new Date(2023, Calendar.FEBRUARY, 12)));
        mockTransactionData.add(new Transaction(1, 90, new Date(2023, Calendar.JUNE, 12)));
    }


    @Override
    public List<Transaction> findAllByUserId(Integer id) {
        return mockTransactionData.stream().filter(transaction -> transaction.getUser_id().equals(id)).collect(Collectors.toList());
    }
}
