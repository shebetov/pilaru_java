package com.boots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/404")
    public String error404() {
        return "/error/404";
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "redirect:/search";
    }

    @GetMapping("/login")
    public String login() {
        return "/accounts/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

}
