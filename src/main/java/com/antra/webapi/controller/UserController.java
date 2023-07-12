package com.antra.webapi.controller;

import com.antra.webapi.entity.User;
import com.antra.webapi.exception.UserNotFoundException;
import com.antra.webapi.service.UserService;
import com.antra.webapi.util.RewardsRecord;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserByid(@PathVariable("id") int id) {
        Optional<User> opt = userService.findUserById(id);
        User user;
        if (opt.isPresent()) {
            user = opt.get();
        } else {
            throw new UserNotFoundException("User Not Found");
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/reward/{id}")
    public ResponseEntity<?> getUserRewards(@PathVariable("id") int id, @PathParam("year") int year) {
        List<Integer> rewards = userService.getMonthlyRewards(id, year);
        return new ResponseEntity<String>(RewardsRecord.monthlyRewardsRecods(rewards) + "Total rewards: " + userService.getTotalRewards(rewards), HttpStatus.OK);

    }

}
