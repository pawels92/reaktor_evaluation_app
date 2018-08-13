package com.evaluation.demo.controller;

import com.evaluation.demo.model.entity.User;
import com.evaluation.demo.model.form.PasswordChangeForm;
import com.evaluation.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
public class UserController {

    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/changePassword")
    public String changePassword(Model model, Authentication auth) {
        PasswordChangeForm passwordChangeForm = new PasswordChangeForm();
//        passwordChangeForm.setPassword1(currentUser.getPassword());
//        passwordChangeForm.setPassword1(currentUser.getPassword());
        model.addAttribute("passwordChangeForm", passwordChangeForm);
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute @Valid PasswordChangeForm passwordChangeForm,
                                 BindingResult bindingResult,
                                 Authentication auth) {
        if(bindingResult.hasErrors()){
            return "change password";
        }
        UserDetails loggedUser = (UserDetails) auth.getPrincipal();
        //zalogowano na adres currentEmail
        String currentEmail = loggedUser.getUsername();
        //zwróć użytkownika - obiekt user, którego zalogowano
        User currentUser = userService.getUser(currentEmail);
        System.out.println(("aktualne: " +currentUser.getPassword()));
        userService.changePassword(passwordChangeForm, currentUser.getId());
        return "changePassword";

    }
}
