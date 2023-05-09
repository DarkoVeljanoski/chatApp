package com.chatapp.messageProducer.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String welcomeMessage(Authentication authentication){

        String name = authentication.getName();

        return "Welcome " + name;

    }
}
