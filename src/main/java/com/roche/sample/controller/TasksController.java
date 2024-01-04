package com.roche.sample.controller;

import com.roche.sample.model.Tasks;
import com.roche.sample.service.TasksService;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("/tasks")
    public String index() {
        return "Greetings from Spring Boot index for tasks!";
    }

    @GetMapping("/tasks/{id}")
    public String get(@PathVariable UUID id) {
        this.tasksService.getTasks(id);
        return "You got tasks" + id + "!";
    }

    @PostMapping("/tasks")
    public String post(@ModelAttribute Tasks tasks) {
        this.tasksService.createTasks(tasks);
        return "You got tasks!";
    }

    // @PatchMapping("/tasks/{id}")
    // public String update(@PathVariable UUID id) {
    //     return "You got tasks" + id + "!";
    // }

    @DeleteMapping("/tasks/{id}")
    public String delete(@PathVariable UUID id) {
        this.tasksService.getTasks(id);
        return "You deleted tasks" + id + "!";
    }
}