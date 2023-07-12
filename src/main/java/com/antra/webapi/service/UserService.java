package com.antra.webapi.service;

import com.antra.webapi.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(Integer id);
}
