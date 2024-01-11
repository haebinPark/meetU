package com.example.codestates.user.service;

import com.example.codestates.user.entitiy.User;
import com.example.codestates.user.repository.UserRepository;
import com.example.codestates.utils.CustomBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final CustomBeanUtils<User> beanUtils;

    public UserService(UserRepository userRepository, CustomBeanUtils<User> beanUtils) {
        this.userRepository = userRepository;
        this.beanUtils = beanUtils;
    }

    public User createUser(){
        return null;
    }

    public User updateUser(){
        return null;

    }
    public User findUser(){
        return null;
    }
    public void deleteUser(){

    }
}
