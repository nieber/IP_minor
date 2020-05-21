package com.example.task.controller;

import com.example.task.domain.Task;
import com.example.task.domain.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class TaskController {

    @Autowired
    TaskRepository repository;

    @GetMapping("/tasks")
    public String overview(Model model){
        model.addAttribute("tasks",repository.getTasks());
        return "overview";
    }

    @GetMapping("/tasks/new")
    public String add(Model model){
        model.addAttribute("task",new Task());
        return "addTask";
    }

    @GetMapping("/tasks/{id}")
    public String detail(Model model, @PathVariable("id") int id){
        model.addAttribute("task",repository.taskById(id));
        return "taskDetail";
    }

    @PostMapping("/tasks/adding")
    public String addTask(Model model, @ModelAttribute Task task){
        this.repository.addTask(task);
        return "redirect:/tasks";
    }

}
