package com.stripeprep.transaction.service;

import com.stripeprep.transaction.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public User createUser(User user) {
        user.setId(idCounter.getAndIncrement());
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
