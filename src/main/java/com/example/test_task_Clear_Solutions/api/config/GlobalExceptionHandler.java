package com.example.test_task_Clear_Solutions.api.config;

import com.example.test_task_Clear_Solutions.api.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(LowAgeException.class)
    public ResponseEntity<AppError> handleLowAgeException(LowAgeException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(EmailContainsSpacesException.class)
    public ResponseEntity<AppError> handleEmailContainsSpacesException(EmailContainsSpacesException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ToIsLessThanFromException.class)
    public ResponseEntity<AppError> handleToIsLessThanFromException(ToIsLessThanFromException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(EmailDoesNotContainEtException.class)
    public ResponseEntity<AppError> handleEmailDoesNotContainEtException(EmailDoesNotContainEtException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(EmptyEmailException.class)
    public ResponseEntity<AppError> handleEmptyEmailException(EmptyEmailException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(EmptyFirstNameException.class)
    public ResponseEntity<AppError> handleEmptyFirstNameException(EmptyFirstNameException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(EmptyLastNameException.class)
    public ResponseEntity<AppError> handleEmptyLastNameException(EmptyLastNameException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(WrongBirthDateException.class)
    public ResponseEntity<AppError> handleWrongBirthDateException(WrongBirthDateException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(PhoneContainsSpacesException.class)
    public ResponseEntity<AppError> handleEmailContainsSpacesException(PhoneContainsSpacesException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(StartsWithPhoneNumberException.class)
    public ResponseEntity<AppError> handleEmailContainsSpacesException(StartsWithPhoneNumberException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }
}