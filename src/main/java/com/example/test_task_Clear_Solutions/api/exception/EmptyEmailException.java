package com.example.test_task_Clear_Solutions.api.exception;

public class EmptyEmailException extends RuntimeException{
    private static final String EMPTY_EMAIL_TEXT = "email: %s is empty";

    public EmptyEmailException(String email) {
        super(String.format(EMPTY_EMAIL_TEXT, email));
    }
}
