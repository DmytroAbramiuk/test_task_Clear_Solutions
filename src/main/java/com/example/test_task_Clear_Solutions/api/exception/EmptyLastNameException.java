package com.example.test_task_Clear_Solutions.api.exception;

public class EmptyLastNameException extends RuntimeException{
    private static final String EMPTY_FIRST_NAME = "last name: %s is empty";

    public EmptyLastNameException(String lastName) {
        super(String.format(EMPTY_FIRST_NAME, lastName));
    }
}
