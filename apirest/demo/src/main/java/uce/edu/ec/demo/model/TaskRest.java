package uce.edu.ec.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "task_rest")
public class TaskRest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status;
    private LocalDate creationDate;

    public TaskRest() {
        this.creationDate = LocalDate.now();
    }

    public TaskRest(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.creationDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
