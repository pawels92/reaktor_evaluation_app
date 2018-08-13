package com.evaluation.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {
<<<<<<< HEAD

    @GetMapping("/register")
    public String register() {
        return "/register";
=======
    @GetMapping("/")
    public String login(){
        return "homepage";
    }
    @GetMapping("/contact")
    public String kontakt() {
        return "contact";
>>>>>>> 3446063b148923a2dc6ae1bd8cb103e693f5963f
    }

}


