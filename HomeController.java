package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Welcome to the home page!";
    }


    @GetMapping("/login")
    public String login() {
        return "you are loged in"; // Returns login.html template
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Returns dashboard.html template
    }

    @GetMapping("/home/tickets")
    public String tickets(){return "tickets";}

    @GetMapping("/create")
    public String create(){return "create_ticket";}

}
