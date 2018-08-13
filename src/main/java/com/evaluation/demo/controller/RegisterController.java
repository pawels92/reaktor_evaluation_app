package com.evaluation.demo.controller;

import com.evaluation.demo.model.entity.User;
import com.evaluation.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("register", new User());

        return "register";
    }
    boolean isDifferent;
    @PostMapping("/register")
    public String register( @ModelAttribute @Valid User register, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
//        if(!register.getPassword().equals(register.getPassword1())){
//            isDifferent = true;
////            model.addAttribute("isDifferent", isDifferent);
//            return "register";
//        }

        //zapis przez klasę z service
        registerService.createUser(register);
        return "redirect:/";
    }
}

