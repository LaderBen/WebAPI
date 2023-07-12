package com.antra.webapi.service;

import com.antra.webapi.entity.Transaction;
import com.antra.webapi.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(Integer id);
    List<Transaction> findUserTransactionByUserId(int user_id);
    List<Integer> getMonthlyRewards(int user_id, int year);
    Integer getTotalRewards(List<Integer> rewards);
}
