package uce.edu.ec.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uce.edu.ec.demo.model.TaskRest;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskRest, Long> {
    List<TaskRest> findByStatus(String status);
}
