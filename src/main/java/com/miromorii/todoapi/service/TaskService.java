package com.miromorii.todoapi.service;

import com.miromorii.todoapi.entity.Task;
import com.miromorii.todoapi.exceptions.ResourceNotFoundException;
import com.miromorii.todoapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> findAll(){
        return repository.findAll();
    }

    public Task findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    public Task create(Task task){
        return repository.save(task);
    }


    public Task update(Task task){
        return repository.save(task);
    }


    public void delete(Long id){
        repository.deleteById(id);
    }
}
