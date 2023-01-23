package com.tweetero.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.main.dto.UserDTO;
import com.tweetero.main.service.UserService;

@RestController
@RequestMapping("/sign-up")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public String create(@RequestBody UserDTO req) {
        service.save(req);
        return "OK";
    }
}
