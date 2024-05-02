package com.example.test_task_Clear_Solutions.api.exception.dates;

import java.time.LocalDate;

public class ToIsLessThanFromException extends RuntimeException{
    private static final String TO_IS_LESS_THEN_FROM_TEXT = "date %s is less than %s";

    public ToIsLessThanFromException(LocalDate from, LocalDate to) {
        super(String.format(TO_IS_LESS_THEN_FROM_TEXT, to, from));
    }
}
