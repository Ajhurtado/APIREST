package uce.edu.ec.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.demo.model.TaskRest;
import uce.edu.ec.demo.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apirest/task_rest")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskRest createTask(@RequestBody TaskRest task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<TaskRest> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRest> getTask(@PathVariable Long id) {
        return taskService.getTask(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/status")
    public List<TaskRest> getTasksByStatus(@RequestParam String status) {
        return taskService.getTasksByStatus(status);
    }

    @PutMapping("/{id}")
    public TaskRest updateTask(@PathVariable Long id, @RequestBody TaskRest taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}