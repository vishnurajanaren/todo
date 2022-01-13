package com.example.todo.service;

import com.example.todo.entity.TodoItem;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TodoService {

    List<TodoItem> getAllTodoItems(String email);

    TodoItem createTodoItem(@RequestBody TodoItem todoItem, String email);

    TodoItem updateTodoItem(@RequestBody TodoItem todoItem);

    String deleteTodoItem(Long id);

    String completeTodoItem(Long id);
}
