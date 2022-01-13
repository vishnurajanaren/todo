package com.example.todo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.todo.entity.TodoItem;
import com.example.todo.repository.TodoItemRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TodoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TodoServiceImplTest {
    @MockBean
    private TodoItemRepository todoItemRepository;

    @Autowired
    private TodoServiceImpl todoServiceImpl;

    @Test
    void testGetAllTodoItems() {
        ArrayList<TodoItem> todoItemList = new ArrayList<>();
        when(this.todoItemRepository.findAllByEmail((String) any())).thenReturn(todoItemList);
        List<TodoItem> actualAllTodoItems = this.todoServiceImpl.getAllTodoItems("jane.doe@example.org");
        assertSame(todoItemList, actualAllTodoItems);
        assertTrue(actualAllTodoItems.isEmpty());
        verify(this.todoItemRepository).findAllByEmail((String) any());
    }

    @Test
    void testCreateTodoItem() {
        TodoItem todoItem = new TodoItem();
        todoItem.setCategory("Category");
        todoItem.setComplete(true);
        todoItem.setEmail("jane.doe@example.org");
        todoItem.setId(123L);
        todoItem.setName("Name");
        when(this.todoItemRepository.save((TodoItem) any())).thenReturn(todoItem);

        TodoItem todoItem1 = new TodoItem();
        todoItem1.setCategory("Category");
        todoItem1.setComplete(true);
        todoItem1.setEmail("jane.doe@example.org");
        todoItem1.setId(123L);
        todoItem1.setName("Name");
        assertSame(todoItem, this.todoServiceImpl.createTodoItem(todoItem1, "jane.doe@example.org"));
        verify(this.todoItemRepository).save((TodoItem) any());
    }

    @Test
    void testUpdateTodoItem() {
        TodoItem todoItem = new TodoItem();
        todoItem.setCategory("Category");
        todoItem.setComplete(true);
        todoItem.setEmail("jane.doe@example.org");
        todoItem.setId(123L);
        todoItem.setName("Name");
        Optional<TodoItem> ofResult = Optional.of(todoItem);

        TodoItem todoItem1 = new TodoItem();
        todoItem1.setCategory("Category");
        todoItem1.setComplete(true);
        todoItem1.setEmail("jane.doe@example.org");
        todoItem1.setId(123L);
        todoItem1.setName("Name");
        when(this.todoItemRepository.save((TodoItem) any())).thenReturn(todoItem1);
        when(this.todoItemRepository.findById((Long) any())).thenReturn(ofResult);

        TodoItem todoItem2 = new TodoItem();
        todoItem2.setCategory("Category");
        todoItem2.setComplete(true);
        todoItem2.setEmail("jane.doe@example.org");
        todoItem2.setId(123L);
        todoItem2.setName("Name");
        assertSame(todoItem1, this.todoServiceImpl.updateTodoItem(todoItem2));
        verify(this.todoItemRepository).findById((Long) any());
        verify(this.todoItemRepository).save((TodoItem) any());
    }

    @Test
    void testDeleteTodoItem() {
        doNothing().when(this.todoItemRepository).deleteById((Long) any());
        assertEquals("Todo item deleted successfully", this.todoServiceImpl.deleteTodoItem(123L));
        verify(this.todoItemRepository).deleteById((Long) any());
    }

    @Test
    void testCompleteTodoItem() {
        TodoItem todoItem = new TodoItem();
        todoItem.setCategory("Category");
        todoItem.setComplete(true);
        todoItem.setEmail("jane.doe@example.org");
        todoItem.setId(123L);
        todoItem.setName("Name");
        Optional<TodoItem> ofResult = Optional.of(todoItem);
        when(this.todoItemRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Unable to complete the task. Task Name is already marked as completed",
                this.todoServiceImpl.completeTodoItem(123L));
        verify(this.todoItemRepository).findById((Long) any());
    }

    @Test
    void testCompleteTodoItem2() {
        TodoItem todoItem = new TodoItem();
        todoItem.setCategory("Category");
        todoItem.setComplete(false);
        todoItem.setEmail("jane.doe@example.org");
        todoItem.setId(123L);
        todoItem.setName("Name");
        Optional<TodoItem> ofResult = Optional.of(todoItem);

        TodoItem todoItem1 = new TodoItem();
        todoItem1.setCategory("Category");
        todoItem1.setComplete(true);
        todoItem1.setEmail("jane.doe@example.org");
        todoItem1.setId(123L);
        todoItem1.setName("Name");
        when(this.todoItemRepository.save((TodoItem) any())).thenReturn(todoItem1);
        when(this.todoItemRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Task Name is marked as completed.", this.todoServiceImpl.completeTodoItem(123L));
        verify(this.todoItemRepository).findById((Long) any());
        verify(this.todoItemRepository).save((TodoItem) any());
    }

    @Test
    void testCompleteTodoItem3() {
        TodoItem todoItem = new TodoItem();
        todoItem.setCategory("Category");
        todoItem.setComplete(true);
        todoItem.setEmail("jane.doe@example.org");
        todoItem.setId(123L);
        todoItem.setName("Name");
        when(this.todoItemRepository.save((TodoItem) any())).thenReturn(todoItem);
        when(this.todoItemRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertEquals("Unable to complete the task.", this.todoServiceImpl.completeTodoItem(123L));
        verify(this.todoItemRepository).findById((Long) any());
    }
}

