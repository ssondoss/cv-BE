package com.cvbuilder.auth.service;


import com.cvbuilder.auth.entity.User;
import com.cvbuilder.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository ;


    public List<User> getAllUsers(){
       return this.userRepository.findAll();

    }

    public User getUserById(Long id){
        return this.userRepository.getReferenceById(id);
    }

    public  User saveUser(User user){
        return this.userRepository.save(user);
    }






}
