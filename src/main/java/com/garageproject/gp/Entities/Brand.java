package com.garageproject.gp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Brand {

    @Id
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
