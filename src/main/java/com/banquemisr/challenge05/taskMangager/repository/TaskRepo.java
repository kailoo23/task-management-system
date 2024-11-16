package com.banquemisr.challenge05.taskMangager.repository;

import com.banquemisr.challenge05.taskMangager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface TaskRepo extends JpaRepository<Task,Long> {
    List<Task> findByUserID(Long userId);

    List<Task> findByTitle(String title);
    
    List<Task> findByStatus(String status);

    List<Task> findByPriority(int priority);

    List<Task> findByTitleContaining(String title);

    // Search tasks by due date
    List<Task> findByDueDate(Date dueDate);

}
