package com.banquemisr.challenge05.taskMangager.services;

import com.banquemisr.challenge05.taskMangager.Exeption.TaskException;
import com.banquemisr.challenge05.taskMangager.entity.Task;
import com.banquemisr.challenge05.taskMangager.entity.User;
import com.banquemisr.challenge05.taskMangager.repository.TaskRepo;
import com.banquemisr.challenge05.taskMangager.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class TaskService {

    private final UserRepo userRepo;
    private final TaskRepo taskRepo;

    public Task createTask(Long userId, Task task) {
        try{
            Optional<User> userOpt = userRepo.findById(userId);
            if (userOpt.isPresent()) {
                task.setUser(userOpt.get());
                taskRepo.save(task);
                log.info("Task created successfully: " + task);
                return task;
            } else {
                throw new TaskException("User not found with ID: " + userId);
            }

        }catch (Exception e){
            log.error(e.getStackTrace());
        }
        return task;
    }

    public Optional<Task> getTaskByID(Long id) {
        return taskRepo.findById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public void updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTaskOpt = taskRepo.findById(id);
        try{
            if (existingTaskOpt.isPresent()) {
                Task existingTask = existingTaskOpt.get();
                existingTask.setTitle(updatedTask.getTitle());
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setStatus(updatedTask.getStatus());
                existingTask.setPriority(updatedTask.getPriority());
                existingTask.setDueDate(updatedTask.getDueDate());
                taskRepo.save(existingTask);
                log.info("Task updated successfully: " + existingTask);
            } else {
                throw new TaskException("Task not found with ID: " + id);
            }
        }catch (Exception e){
            log.error(e.getStackTrace());
        }
    }

    public List<Task> searchTasksByTitle(String title) {
        return taskRepo.findByTitle(title);
    }
    public List<Task> searchTasksByStatus(String status) {
        return taskRepo.findByStatus(status);
    }
    public List<Task> searchTasksByPriority(int priority) {
        return taskRepo.findByPriority(priority);
    }
    public void deleteTask(Long id) {
        try {
            if (taskRepo.existsById(id)) {
                taskRepo.deleteById(id);
                log.info("Task deleted successfully with ID: " + id);

            } else {
                throw new TaskException("Task not found with ID: " + id);
            }
        }catch (Exception e){
            log.error(e.getStackTrace());
        }
    }

    public List<Task> getTasksByUserID(Long userId) {
        return taskRepo.findByUserID(userId);
    }
}