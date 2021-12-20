package com.boots.controller;

import com.boots.entity.User;
import com.boots.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.google.gson.Gson;


import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(MyAccessDeniedHandler.class);

    @GetMapping("/registration")
    public String registration(Model model) {
        return "accounts/registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        Gson gson = new Gson();
        logger.info(gson.toJson(bindingResult));
        if (bindingResult.hasErrors()) {
            return "accounts/registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "accounts/registration";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "accounts/registration";
        }

        return "redirect:/";
    }
}