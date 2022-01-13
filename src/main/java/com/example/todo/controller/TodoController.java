package com.example.todo.controller;

import com.example.todo.entity.TodoItem;
import com.example.todo.model.UserData;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserData userData;

    @GetMapping("/task/all")
    public List<TodoItem> getAll() {
        return todoService.getAllTodoItems(userData.getEmail());
    }

    @PostMapping("/task/create")
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
        return todoService.createTodoItem(todoItem, userData.getEmail());
    }

    @PutMapping("/task/update")
    public TodoItem updateTodoItem(@RequestBody TodoItem todoItem) {
        return todoService.updateTodoItem(todoItem);
    }

    @PatchMapping("/task/complete/{id}")
    public String completeTodoItem(@PathVariable("id") Long id) {
        return todoService.completeTodoItem(id);
    }

    @DeleteMapping("/task/delete/{id}")
    public String deleteTodoItem(@PathVariable("id")
                                         Long todoItemId) {
        return todoService.deleteTodoItem(todoItemId);
    }

}
