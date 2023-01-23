package com.example.E16.entity;

import jakarta.persistence.*;


@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Boolean completed;

    public Integer getId() {
        return id;
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

    public Boolean getCompleted() {

        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }



    public String convert(Boolean bool){
        if(bool){
            return "Completed";
        } else {
            return "Not completed";
        }
    }
}
