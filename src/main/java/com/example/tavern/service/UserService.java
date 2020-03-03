package com.example.tavern.service;

import com.example.tavern.dao.UserRepository;
import com.example.tavern.model.User;
import com.example.tavern.other.Load;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User getUser(long id)
    {
        Optional<User> optionalUser = userRepository.findById(id);
        User user;
        if (optionalUser.isPresent()){
            return Load.populateUser(optionalUser.get());
        }
        else
        {
            throw new Error("User not found");
        }
    }
}
