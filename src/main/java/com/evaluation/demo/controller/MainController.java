package com.evaluation.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {

    @GetMapping("/")
    public String login(){
        return "homepage";
    }
    @GetMapping("/contact")
    public String kontakt() {
        return "contact";

    }

}


