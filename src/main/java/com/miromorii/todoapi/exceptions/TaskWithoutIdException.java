package com.miromorii.todoapi.exceptions;

public class TaskWithoutIdException extends RuntimeException{

    public TaskWithoutIdException(String message){
        super(message);
    }

    public TaskWithoutIdException(){
        super("Task without id");
    }
}
