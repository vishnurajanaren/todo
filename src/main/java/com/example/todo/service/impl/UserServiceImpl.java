package com.example.todo.service.impl;

import com.example.todo.entity.UserEntity;
import com.example.todo.repository.UserRepository;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserEntity loadUserByUsername(String email) {
        return userRepository.findByEmail(email);
    }

}
