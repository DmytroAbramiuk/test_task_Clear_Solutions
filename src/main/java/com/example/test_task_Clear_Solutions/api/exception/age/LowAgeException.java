package com.example.test_task_Clear_Solutions.api.exception.age;

public class LowAgeException extends RuntimeException{
    private static final String LOW_AGE_TEXT = "your age: %d is too low";

    public LowAgeException(Integer age) {
        super(String.format(LOW_AGE_TEXT, age));
    }
}
