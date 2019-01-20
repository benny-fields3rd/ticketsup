package com.codeup.ticketsup.services;

import com.codeup.ticketsup.interfaces.UserRepository;
import com.codeup.ticketsup.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService( UserRepository userRepo){

        this.userRepo = userRepo;
    }

    public List<User> allUsers(){
        return (List<User>) userRepo.findAll();
    }

    public User singleUser(int id){
        return userRepo.findOne(id);
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(User user){
        userRepo.delete(user);
    }



}
