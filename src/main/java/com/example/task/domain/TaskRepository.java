package com.example.task.domain;

import java.util.List;

public interface TaskRepository {

    List<Task> getTasks();

    Task taskById(int id);

    void addTask(Task task);
}
