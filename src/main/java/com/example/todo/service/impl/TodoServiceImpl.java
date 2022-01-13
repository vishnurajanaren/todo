package com.example.todo.service.impl;

import com.example.todo.entity.TodoItem;
import com.example.todo.repository.TodoItemRepository;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoItemRepository todoItemRepository;


    public List<TodoItem> getAllTodoItems(String email) {
        return (List<TodoItem>) todoItemRepository.findAllByEmail(email);
    }

    public TodoItem createTodoItem(@RequestBody TodoItem todoItem, String email) {
        return todoItemRepository.save(new TodoItem(todoItem.getId(), todoItem.getCategory(), todoItem.getName(), todoItem.isComplete(), email));
    }

    public TodoItem updateTodoItem(@RequestBody TodoItem todoItem) {
        TodoItem todoItemEntity = todoItemRepository.findById(todoItem.getId()).orElse(null);
        if (todoItem != null) {
            todoItemEntity.setName(todoItem.getName());
        }
        return todoItemRepository.save(todoItemEntity);
    }

    public String deleteTodoItem(Long id) {
        todoItemRepository.deleteById(id);
        return "Todo item deleted successfully";
    }

    @Override
    public String completeTodoItem(Long id) {
        TodoItem todoItem = todoItemRepository.findById(id).orElse(null);
        if (todoItem != null) {
            if (!todoItem.isComplete()) {
                todoItem.setComplete(true);
                todoItemRepository.save(todoItem);
                return "Task " + todoItem.getName() + " is marked as completed.";
            } else {
                return "Unable to complete the task. Task " + todoItem.getName() + " is already marked as completed";
            }
        }
        return "Unable to complete the task.";
    }
}
