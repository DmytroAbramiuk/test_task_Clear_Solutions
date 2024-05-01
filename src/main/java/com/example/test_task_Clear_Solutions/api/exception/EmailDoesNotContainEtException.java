package com.example.test_task_Clear_Solutions.api.exception;

public class EmailDoesNotContainEtException extends RuntimeException {
    private static final String EMAIL_DOES_NOT_CONTAIN_ET_TEXT = "email: %s does not contain @";

    public EmailDoesNotContainEtException(String email) {
        super(String.format(EMAIL_DOES_NOT_CONTAIN_ET_TEXT, email));
    }
}
