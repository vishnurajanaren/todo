package com.example.todo.repository;

import com.example.todo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByEmail(String email);

}
