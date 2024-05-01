package com.example.test_task_Clear_Solutions.api.exception;

import java.time.LocalDate;

public class WrongBirthDateException extends RuntimeException{
    private static final String WRONG_BIRTHDAY_TEXT = "date: %s in the future";

    public WrongBirthDateException(LocalDate birthday) {
        super(String.format(WRONG_BIRTHDAY_TEXT, birthday.toString()));
    }
}
