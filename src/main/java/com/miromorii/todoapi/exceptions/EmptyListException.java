package com.miromorii.todoapi.exceptions;

public class EmptyListException extends RuntimeException{

    public EmptyListException(){
        super("the list is empty");
    }

    public EmptyListException(String message){
        super(message);
    }


}
