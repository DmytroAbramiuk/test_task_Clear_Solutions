package com.example.test_task_Clear_Solutions.api.config;

import com.example.test_task_Clear_Solutions.api.exception.*;
import com.example.test_task_Clear_Solutions.api.service.dto.UserDto;

import java.time.LocalDate;
import java.time.Period;

public class Validator {
    public static void validateUser(UserDto dto){
        if(dto.getEmail().isEmpty()){
            throw new EmptyEmailException(dto.getEmail());
        }
        if(dto.getEmail().contains(" ")){
            throw new EmailContainsSpacesException(dto.getEmail());
        }
        if(!dto.getEmail().contains("@")){
            throw new EmailDoesNotContainEtException(dto.getEmail());
        }
        if(dto.getFirstName().isEmpty()){
            throw new EmptyFirstNameException(dto.getFirstName());
        }
        if(dto.getLastName().isEmpty()){
            throw new EmptyLastNameException(dto.getLastName());
        }
        if(dto.getPhoneNumber().contains(" ")){
            throw new PhoneContainsSpacesException(dto.getPhoneNumber());
        }
        if(!dto.getPhoneNumber().startsWith("+")){
            throw new StartsWithPhoneNumberException(dto.getPhoneNumber());
        }
        if(dto.getBirthday().isAfter(LocalDate.now())){
            throw new WrongBirthDateException(dto.getBirthday());
        }
        Integer age = Period.between(dto.getBirthday(), LocalDate.now()).getYears();
        if (age < PropertyReader.read()){
            throw new LowAgeException(age);
        }
    }

    public static void validateSearchDates(LocalDate from, LocalDate to){
        if(from.isAfter(to)){
            throw new ToIsLessThanFromException(from, to);
        }
    }
}
