package com.utm.EmployeeManagement.exception;

public class AlreadyExistException extends RuntimeException{

    private String message;

    public AlreadyExistException(String message){
        super(message);
        this.message = message;
    }
}
