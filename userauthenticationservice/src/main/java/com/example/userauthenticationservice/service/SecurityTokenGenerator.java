package com.example.userauthenticationservice.service;

import com.example.userauthenticationservice.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String, String> generateToken(User user);
}
