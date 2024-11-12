package com.miromorii.todoapi.DTO;

import lombok.Getter;

@Getter
public class PutTaskDTO {

    private Long id;
    private String name;
    private String description;
}
