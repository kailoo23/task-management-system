package com.banquemisr.challenge05.taskMangager.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "History")
public class History {


    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
