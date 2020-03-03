package com.ahmadmongo.ahmadmongo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asdf")
public class NaniController {

    @GetMapping(value = "/asiiap")
    public String sip() {
        return "Hello World!";
    }
}
