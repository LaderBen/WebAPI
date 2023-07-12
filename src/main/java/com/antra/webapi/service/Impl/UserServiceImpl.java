package com.antra.webapi.service.Impl;

import com.antra.webapi.dao.TransactionRepository;
import com.antra.webapi.dao.UserRepository;
import com.antra.webapi.entity.Transaction;
import com.antra.webapi.entity.User;
import com.antra.webapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserRepository userRepo;

    private TransactionRepository transactionRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, TransactionRepository transactionRepository) {
        this.userRepo = userRepo;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public List<Transaction> findUserTransactionByUserId(int user_id) {
        return transactionRepository.findAllByUserId(user_id);
    }

    /**
     * @param user_id
     * @param year
     * @return List<Integer> return the year rewards detail for each moth
     */
    @Override
    public List<Integer> getMonthlyRewards(int user_id, int year) {
        List<Transaction> list = findUserTransactionByUserId(user_id);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int finalI = i;
            List<Integer> filtered = list.stream()
                    .filter((transaction -> transaction.getPurchase()>50))
                    .filter(transaction -> transaction.getDate().getYear() == year)
                    .filter(transaction -> transaction.getDate().getMonth() == finalI)
                    .map(Transaction::getPurchase)
                    .toList();
            int monthlyTotal = 0;
            for (Integer p: filtered) {
                if(p>=100){
                    monthlyTotal = monthlyTotal + 50 + 2*(p-100);
                } else {
                    monthlyTotal = monthlyTotal + p - 50;
                }
            }
            res.add(monthlyTotal);
        }
        return res;
    }

    /**
     *
     * @param rewards
     * @return Integer
     * return the sum of the rewards list
     */
    @Override
    public Integer getTotalRewards(List<Integer> rewards) {
        return rewards.stream().reduce(0, Integer::sum);
    }
}
