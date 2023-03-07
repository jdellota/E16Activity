package com.example.E16.controller;

import com.example.E16.entity.Task;
import com.example.E16.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;
    @GetMapping("/list")
    public String viewTask(Model model)
    {
        model.addAttribute("tasks", taskService.displayTasks());
        return "taskList";
    }
    @GetMapping("/addtaskform")
    public String addtaskform(Model model)
    {
        return "addtaskform";
    }
    @PostMapping("/addtask")
    public String addTask(@ModelAttribute("task") Task task, Model model)
    {
        taskService.createTask(task.getTitle(), task.getDescription());
        model.addAttribute("tasks", taskService.displayTasks());
        return "taskList";
    }
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") int id, Model model){
        taskService.deleteTask(id);
        model.addAttribute("tasks", taskService.displayTasks());
        return "taskList";
    }

    @GetMapping("/edittasklist/{id}")
    public String editTask(@PathVariable("id") int id, Model model){

        model.addAttribute("task", taskService.getTask(id));
        return "edittaskform";
    }
    @PostMapping("/edit/{id}")
    public String deleteTask(@PathVariable("id") int id, @ModelAttribute Task task, Model model){
        taskService.updateTask(id, task.getTitle(), task.getDescription(), task.getCompleted());
        model.addAttribute("tasks", taskService.displayTasks());
        return "taskList";
    }
}
