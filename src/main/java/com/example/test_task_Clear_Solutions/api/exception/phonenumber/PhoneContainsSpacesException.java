package com.example.test_task_Clear_Solutions.api.exception.phonenumber;

public class PhoneContainsSpacesException extends RuntimeException {
    private static final String PHONE_NUMBER_CONTAIN_SPACES_TEXT = "the phone number: %s contains spaces";

    public PhoneContainsSpacesException(String phone) {
        super(String.format(PHONE_NUMBER_CONTAIN_SPACES_TEXT, phone));
    }
}