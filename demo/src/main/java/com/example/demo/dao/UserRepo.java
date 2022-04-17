package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer>{
    
    List<User> findUserByIdUser(int id);
    
}
