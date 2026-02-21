package com.projeto.taskflow.service;

import com.projeto.taskflow.model.Task;
import com.projeto.taskflow.model.Priority;
import com.projeto.taskflow.model.Status;
import com.projeto.taskflow.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found: " + id));
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Long id, Task updatetask) {
        Task existingTask = findById(id);
        existingTask.setTitle(updatetask.getTitle());
        existingTask.setDescription(updatetask.getDescription());
        existingTask.setStatus(updatetask.getStatus());
        existingTask.setPriority(updatetask.getPriority());
        return taskRepository.save(existingTask);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> findByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }
}
