package com.example.E16.controller;

import com.example.E16.entity.Task;
import com.example.E16.service.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping(path="/create")
    public @ResponseBody Task createTask (@RequestParam String title,
                                          @RequestParam String description){
        return taskService.createTask(title, description);

    }


    @GetMapping(path="/display")
    public @ResponseBody Iterable<Task> displayTasks() {
        return taskService.displayTasks();
    }

    @PutMapping(path= "/update")
    public @ResponseBody String changeStatus(@RequestParam int id, @RequestParam String title,
                                                   @RequestParam String description, @RequestParam Boolean completed) {
        return taskService.updateTask(id, title, description, completed);
    }

    @DeleteMapping(path= "/delete")
    @Transactional
    public @ResponseBody String changeStatus(@RequestParam int id) {
        return taskService.deleteTask(id);
    }
}
