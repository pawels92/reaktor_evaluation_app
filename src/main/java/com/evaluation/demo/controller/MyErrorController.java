package com.evaluation.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyErrorController implements ErrorController {

        @GetMapping("/error")
        public String errorLogging(){
            //operacje dla error
            return "errorPage";
        }

        //gdy nie ma mappingu na wskazany adres przechodzimy na /error

        @Override
        public String getErrorPath(){
            return "/error";
        }

    }

