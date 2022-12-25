package com.example.StudentManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    /*The serialVersionUID is a universal version identifier for a Serializable class.
    Deserialization uses this number to ensure that a loaded class corresponds exactly
    to a serialized object. If no match is found, then an InvalidClassException is thrown.*/
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }

}
