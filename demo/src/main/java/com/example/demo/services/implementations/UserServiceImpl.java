package com.example.demo.services.implementations;

import java.util.List;
import java.util.Optional;

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


    @Override
    public User getById(int id) {
        // TODO Auto-generated method stub
        Optional<User> result = userRepo.findById(id);
        
        User usrTemp = null;

        if(result.isPresent()){
            usrTemp = result.get();
        }
        else{
            // we didn't find the barang
			throw new RuntimeException("Did not find barang id - " + id);
        }
        return usrTemp;
    }


    @Override
    public void saveBarang(User usr) {
        userRepo.save(usr);
        
    }

    

    
    
}
