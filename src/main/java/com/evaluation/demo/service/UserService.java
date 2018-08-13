package com.evaluation.demo.service;

import com.evaluation.demo.model.entity.User;
import com.evaluation.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String email) {
        User user = userRepository.findOneByEmail(email);
        return user;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
