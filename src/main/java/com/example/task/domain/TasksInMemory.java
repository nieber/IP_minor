package com.example.task.domain;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TasksInMemory implements TaskRepository{


    private List<Task> tasks;
    private int taskID = 3;

    public TasksInMemory() {
        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("task 1","the first task",LocalDateTime.now().plusDays(5),0));
        tasks.add(new Task("task 2","the second task",LocalDateTime.now().plusDays(10),1));
        tasks.add(new Task("task 3","the third task",LocalDateTime.now().plusDays(15),2));

        this.tasks = tasks;
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        task.setId(taskID);
        this.taskID++;
        this.tasks.add(task);
    }

    @Override
    public Task taskById(int id) {
        try {
            return tasks.get(id);
        } catch (Exception e){
            return null;
        }
    }
}
