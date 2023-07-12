package com.antra.webapi.controller;

import com.antra.webapi.entity.User;
import com.antra.webapi.exception.UserNotFoundException;
import com.antra.webapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserByid(@PathVariable("id") int id){
        Optional<User> opt = userService.findUserById(id);
        User user;
        if (opt.isPresent()){
            user = opt.get();
        } else {
            throw new UserNotFoundException("User Not Found");
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

}
