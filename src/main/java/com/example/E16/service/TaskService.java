package com.example.E16.service;

import com.example.E16.entity.Task;
import com.example.E16.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    public Task createTask(String title, String description) {
        Task task=new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false);
        taskRepository.save(task);
        return task;
    }

    public List<Task> displayTasks() {
        return taskRepository.findAll();
    }





    public String updateTask(int id, String title, String description, Boolean completed) {
        Task task = taskRepository.getReferenceById((long) id);
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(completed);
        taskRepository.save(task);
        return "Task updated";
    }


    public String deleteTask(int id) {
        taskRepository.deleteById((long) id);
        return "Task deleted";
    }
}
