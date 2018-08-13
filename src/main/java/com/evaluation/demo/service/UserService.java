package com.evaluation.demo.service;


import com.evaluation.demo.model.entity.Role;
import com.evaluation.demo.model.entity.User;
import com.evaluation.demo.model.form.PasswordChangeForm;
import com.evaluation.demo.model.form.RegisterUserForm;
import com.evaluation.demo.repository.RoleRepository;
import com.evaluation.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import com.evaluation.demo.model.entity.User;
import com.evaluation.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createUser (RegisterUserForm registerUserForm) {
        User user = new User();
        user.setFirstname(registerUserForm.getFirstname());
        user.setLastname(registerUserForm.getLastname());
        user.setEmail(registerUserForm.getEmail());
        user.setPassword(registerUserForm.getPassword());
        // szyfrowanie hasła
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // przypisanie roli do usera -> ROLE_USER
        Role role = roleRepository.findOneByRoleName("ROLE_USER");
        // dodanie ról do zbioru
        Set<Role> roleSet = new HashSet<Role>();
        //dodaję role zwracaną przez zapytanie do zbioru
        roleSet.add(role);
        user.setRoles(roleSet);
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User getUser(String email){
        User user = userRepository.findOneByEmail(email);
        return user;
    }
    public User changePassword (PasswordChangeForm passwordChangeForm, Long id){
        // metoda Hibernate do modyfikacji usera
        //metoda getOne do modyfikacji danych
        User modifiedUser = userRepository.getOne(id);
        //kodowanie hasła
        // przepisanie wartosci hasła
        modifiedUser.setPassword(bCryptPasswordEncoder.encode(passwordChangeForm.getPassword1()));
        //update
        return userRepository.save(modifiedUser);

    }



    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
