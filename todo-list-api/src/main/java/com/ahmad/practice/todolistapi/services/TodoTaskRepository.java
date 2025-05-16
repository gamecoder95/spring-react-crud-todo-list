package com.ahmad.practice.todolistapi.services;

import com.ahmad.practice.todolistapi.api.models.TodoTask;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoTaskRepository extends MongoRepository<TodoTask, String> {
}
