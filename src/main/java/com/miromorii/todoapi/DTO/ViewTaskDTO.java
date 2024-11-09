package com.miromorii.todoapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ViewTaskDTO {
    private Long id;
    private String name;
    private String description;
}
