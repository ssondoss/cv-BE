package com.cvbuilder.auth.service;


import com.cvbuilder.auth.entity.User;
import com.cvbuilder.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository ;
    private RedisTemplate<String,Object> redisTemplate;

    public List<User> getAllUsers(){
       return this.userRepository.findAll();

    }

    public User getUserById(Long id){
        return this.userRepository.getReferenceById(id);
    }

    public  User saveUser(User user){
        ValueOperations<String,Object> ops= redisTemplate.opsForValue();
        ops.set(user.getUsername(),user);
        return this.userRepository.save(user);
    }






}
