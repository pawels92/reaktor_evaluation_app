package com.evaluation.demo.service;

import com.evaluation.demo.model.entity.User;
import com.evaluation.demo.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    RegisterRepository registerRepository;
    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }
    public User createUser(User user) {
        User savedUser = registerRepository.save(user);
        return savedUser;
    }
}
