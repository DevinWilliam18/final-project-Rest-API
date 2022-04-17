package com.example.demo.services;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
    List<User> getAllById(int id);
    
}
