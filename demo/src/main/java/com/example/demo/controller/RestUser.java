package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestUser {

    private UserService usrService;

    @Autowired
    public RestUser(UserService usrService) {
        this.usrService = usrService;
    }

    @GetMapping("/barang/{userId}")
    public List<User> getAllByIdUser(@PathVariable int userId){

        return usrService.getAllById(userId);
    }

    
    
}
