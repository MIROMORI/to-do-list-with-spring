package com.miromorii.todoapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;


public record ViewTaskDTO(Long id, String name, String description) {
}
