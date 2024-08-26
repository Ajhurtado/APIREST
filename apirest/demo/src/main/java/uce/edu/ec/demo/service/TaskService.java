package uce.edu.ec.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.demo.model.TaskRest;
import uce.edu.ec.demo.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskRest createTask(TaskRest task) {
        return taskRepository.save(task);
    }

    public List<TaskRest> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskRest> getTask(Long id) {
        return taskRepository.findById(id);
    }

    public List<TaskRest> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public TaskRest updateTask(Long id, TaskRest taskDetails) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(taskDetails.getTitle());
                    task.setDescription(taskDetails.getDescription());
                    task.setStatus(taskDetails.getStatus());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task no encontrada"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}