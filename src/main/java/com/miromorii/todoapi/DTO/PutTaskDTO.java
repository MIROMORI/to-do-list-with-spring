package com.miromorii.todoapi.DTO;

import lombok.Getter;


public record PutTaskDTO(Long id, String name, String description) {

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }
}
