package com.beebop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class RestWelcomeController implements WelcomeController {
    @GetMapping("/{name}")
    public String getWelcomeMessage(@PathVariable("name") String name) {
        return "Welcome " + name;
    }
}
