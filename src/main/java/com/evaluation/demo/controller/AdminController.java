package com.evaluation.demo.controller;

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
    @GetMapping("/adminView")
    public String adminPanel(Model model, Authentication auth) {

            UserDetails principal = (UserDetails) auth.getPrincipal();
            Collection<GrantedAuthority> authList = (Collection<GrantedAuthority>) principal.getAuthorities();
            Boolean isAdmin = authList.contains(new SimpleGrantedAuthority("role_admin"));
            model.addAttribute("isAdmin", isAdmin);
            return "/adminPanel";
        }


}
