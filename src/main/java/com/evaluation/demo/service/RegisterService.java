package com.evaluation.demo.service;

import com.evaluation.demo.model.entity.User;
import com.evaluation.demo.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    RegisterRepository registerRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }
    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User savedUser = registerRepository.save(user);
        return savedUser;
    }
}
