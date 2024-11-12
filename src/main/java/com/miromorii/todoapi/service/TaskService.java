package com.miromorii.todoapi.service;

import com.miromorii.todoapi.DTO.PostTaskDTO;
import com.miromorii.todoapi.DTO.PutTaskDTO;
import com.miromorii.todoapi.DTO.ViewTaskDTO;
import com.miromorii.todoapi.converter.TaskConverterDTO;
import com.miromorii.todoapi.exceptions.EmptyListException;
import com.miromorii.todoapi.exceptions.ResourceNotFoundException;
import com.miromorii.todoapi.exceptions.TaskWithoutIdException;
import com.miromorii.todoapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskConverterDTO converter;

    public List<ViewTaskDTO> findAll(){
        var result = converter.taskToDTO(repository.findAll());
        if(result.isEmpty()){
            throw new EmptyListException();
        } else {
            return result;
        }

    }

    public ViewTaskDTO findById(Long id){ return converter.taskToDTO(repository.findById(id).orElseThrow(ResourceNotFoundException::new));}

    public ViewTaskDTO create(PostTaskDTO task) { return converter.taskToDTO(repository.save(converter.postDTOToTask(task)));}


    public ViewTaskDTO update(PutTaskDTO task){
        if(task.getId() == null){
            throw new TaskWithoutIdException();
        }
        return converter.taskToDTO(repository.save(converter.putDTOToTask(task)));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
