package com.miromorii.todoapi.controller;


import com.miromorii.todoapi.DTO.ViewTaskDTO;
import com.miromorii.todoapi.converter.TaskConverterDTO;
import com.miromorii.todoapi.entity.Task;
import com.miromorii.todoapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public List<ViewTaskDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public ViewTaskDTO findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @PostMapping
    public ViewTaskDTO create(@RequestBody Task task){
        return service.create(task);
    }

    @PutMapping
    public ViewTaskDTO update(@RequestBody Task task){
        return service.update(task);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
