package com.example.demo.services;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
    void saveBarang(User usr);
    List<User> getAllById(int id);
    User getById(int id);
    
}
