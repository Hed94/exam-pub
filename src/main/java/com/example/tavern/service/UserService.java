package com.example.tavern.service;

import com.example.tavern.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;
}
