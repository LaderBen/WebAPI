package com.antra.webapi.dao.impl;

import com.antra.webapi.dao.UserRepository;
import com.antra.webapi.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static Set<User> mockData = new HashSet<>();

    static {
        mockData.add(new User(1, "Ben"));
        mockData.add(new User(2, "Charli"));
        mockData.add(new User(3, "Tom"));
        mockData.add(new User(4, "John"));
    }


    @Override
    public Optional<User> findById(Integer id) {
        return mockData.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
