package com.antra.webapi.dao;

import com.antra.webapi.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Integer id);
}
