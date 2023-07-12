package com.antra.webapi.dao;

import com.antra.webapi.entity.Transaction;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> findAllByUserId(Integer id);
}
