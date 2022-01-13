package com.example.todo.repository;

import com.example.todo.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {

    List<TodoItem> findAllByEmail(String email);

}
