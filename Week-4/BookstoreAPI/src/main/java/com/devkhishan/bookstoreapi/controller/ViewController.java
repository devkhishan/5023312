package com.devkhishan.bookstoreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ViewController {

    @GetMapping("/showRegister")
    public String showRegisterForm(){
        return "register";
    }

}
