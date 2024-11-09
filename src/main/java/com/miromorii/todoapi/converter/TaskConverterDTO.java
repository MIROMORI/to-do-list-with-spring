package com.miromorii.todoapi.converter;

import com.miromorii.todoapi.DTO.ViewTaskDTO;
import com.miromorii.todoapi.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskConverterDTO {

    public ViewTaskDTO taskToDTO(Task task){
        ViewTaskDTO dto = new ViewTaskDTO(task.getId(),
                                          task.getName(),
                                          task.getDescription());
        return dto;
    }

    public List<ViewTaskDTO> taskToDTO(List<Task> tasks){
        List<ViewTaskDTO> dtos = new ArrayList<>();
        for(Task task: tasks){
            dtos.add(taskToDTO(task));
        }
        return dtos;
    }
}
