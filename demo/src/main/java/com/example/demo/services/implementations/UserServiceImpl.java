package com.example.demo.services.implementations;

import java.util.List;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{


    private UserRepo userRepo;

    
    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public List<User> getAllById(int id) {
        


        return userRepo.findUserByIdUser(id);
    }

    

    
    
}
