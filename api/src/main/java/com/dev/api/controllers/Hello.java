package com.dev.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Hello {

    @GetMapping("/")
    public String ola() {
        return "Ola";
    }
}
