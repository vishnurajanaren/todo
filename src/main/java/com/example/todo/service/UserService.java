package com.example.todo.service;

import com.example.todo.entity.UserEntity;

public interface UserService {

    UserEntity loadUserByUsername(String email);
}
