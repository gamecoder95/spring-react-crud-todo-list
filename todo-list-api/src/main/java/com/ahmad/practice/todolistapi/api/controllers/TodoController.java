package com.ahmad.practice.todolistapi.api.controllers;

import com.ahmad.practice.todolistapi.api.models.TodoTask;
import com.ahmad.practice.todolistapi.api.models.TodoTaskDTO;
import com.ahmad.practice.todolistapi.services.TodoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService)
    {
        this.todoService = todoService;
    }

    @GetMapping("/get")
    public List<TodoTask> getTodoTasks()
    {
        return todoService.getTodoTasks();
    }

    @PostMapping("/add")
    public TodoTask addNewTodoTask(@RequestBody TodoTaskDTO taskRequest)
    {
        return todoService.addNewTodoTask(taskRequest.taskValue());
    }

    @PutMapping("/update/{id}")
    public TodoTask updateTaskStatus(@PathVariable String id, @RequestBody TodoTaskDTO taskRequest)
    {
        return todoService.updateTodoTask(id, taskRequest.taskValue(), taskRequest.isDone());
    }

    @DeleteMapping("/delete/{id}")
    public TodoTask deleteTask(@PathVariable String id)
    {
        return todoService.deleteTodoTask(id);
    }
}
