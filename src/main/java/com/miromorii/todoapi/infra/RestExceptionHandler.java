package com.miromorii.todoapi.infra;

import com.miromorii.todoapi.exceptions.EmptyListException;
import com.miromorii.todoapi.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorMessage> exceptionHandler(Exception ex){
        RestErrorMessage error = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RestErrorMessage> resourceNotFoundHandler(Exception ex){
        RestErrorMessage error = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<RestErrorMessage> emptyListExceptionHandler(Exception ex){
        RestErrorMessage error = new RestErrorMessage(HttpStatus.NO_CONTENT, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RestErrorMessage> runtimeExceptionHandler(Exception ex){
        RestErrorMessage error = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<RestErrorMessage> methodNotAllowedExceptionHandler(Exception ex){
        RestErrorMessage error = new RestErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
