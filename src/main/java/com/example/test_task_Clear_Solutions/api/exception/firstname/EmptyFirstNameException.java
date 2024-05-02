package com.example.test_task_Clear_Solutions.api.exception.firstname;

public class EmptyFirstNameException extends RuntimeException{
    private static final String EMPTY_FIRST_NAME = "first name: %s is empty";

    public EmptyFirstNameException(String firstName) {
        super(String.format(EMPTY_FIRST_NAME, firstName));
    }
}
