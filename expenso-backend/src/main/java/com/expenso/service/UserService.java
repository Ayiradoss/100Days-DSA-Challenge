package com.expenso.service;

import com.expenso.model.User;

import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> loginUser(String email, String password);
}
