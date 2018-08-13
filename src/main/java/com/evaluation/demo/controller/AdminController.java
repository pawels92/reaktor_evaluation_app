package com.evaluation.demo.controller;

import com.evaluation.demo.model.entity.User;
import com.evaluation.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class AdminController {
    UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adminView")
    public String adminPanel(Model model) {
        List<User> userList = userService.getUsers();
        model.addAttribute("userList",userList);
        return "adminPanel";
        }




}
