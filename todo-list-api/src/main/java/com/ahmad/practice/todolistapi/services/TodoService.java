package com.ahmad.practice.todolistapi.services;

import com.ahmad.practice.todolistapi.api.models.TodoTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoTaskRepository repository;

    public TodoService(TodoTaskRepository repository)
    {
        this.repository = repository;
    }

    public List<TodoTask> getTodoTasks()
    {
        return repository.findAll();
    }

    public TodoTask addNewTodoTask(String taskValue)
    {
        return repository.insert(new TodoTask(taskValue));
    }


    public TodoTask updateTodoTask(String id, String taskValue, boolean isDone)
    {
        if (!repository.existsById(id))
        {
            throw new IllegalArgumentException("ERROR: taskValue with ID " + id + " does not exist in the collection.");
        }

        var todoTaskOptional = repository.findById(id);
        if (todoTaskOptional.isEmpty())
        {
            throw new IllegalArgumentException("ERROR: taskValue with ID " + id + " does not exist in the collection - even though it should already exist.");
        }

        var updatedTodoTask = todoTaskOptional.get();
        updatedTodoTask.setTaskValue(taskValue);
        updatedTodoTask.setIsDone(isDone);

        repository.save(updatedTodoTask);

        return updatedTodoTask;
    }


    public TodoTask deleteTodoTask(String id)
    {
        if (!repository.existsById(id))
        {
            throw new IllegalStateException("ERROR: taskValue with ID " + id + " does not exist in the collection.");
        }

        var todoTaskOptional = repository.findById(id);
        if (todoTaskOptional.isEmpty())
        {
            throw new IllegalArgumentException("ERROR: taskValue with ID " + id + " does not exist in the collection - even though it should already exist.");
        }

        var updatedTodoTask = todoTaskOptional.get();

        repository.deleteById(id);

        return updatedTodoTask;
    }
}
