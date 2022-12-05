package com.example.userauthenticationservice.service;

import com.example.userauthenticationservice.domain.User;
import com.example.userauthenticationservice.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public User saveUser(User user);

    public List<User> getAllUsers();

    public User loginCheck(String userName, String password) throws UserNotFoundException;

    public Optional<User> getByUserId(int userId);

    public boolean deleteById(int userId);
}
