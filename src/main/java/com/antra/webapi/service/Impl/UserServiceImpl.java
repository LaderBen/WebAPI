package com.antra.webapi.service.Impl;

import com.antra.webapi.dao.UserRepository;
import com.antra.webapi.entity.User;
import com.antra.webapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;


    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepo.findById(id);
    }
}
