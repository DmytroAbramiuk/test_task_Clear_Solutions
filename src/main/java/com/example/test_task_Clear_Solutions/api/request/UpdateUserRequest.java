package com.example.test_task_Clear_Solutions.api.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    @Pattern(regexp = ".*@.*", message = "Email must contain at least one '@' symbol.")
    @Size(min = 2, max = 100, message = "The email length must be between 2 and 100 characters.")
    @NotBlank(message = "email shouldn't have any whitespaces!")
    @NotNull(message = "email is empty!")
    private String email;

    @Size(min = 2, max = 50, message = "The first name length must be between 2 and 50 characters.")
    @NotNull
    private String firstName;

    @Size(min = 2, max = 50, message = "The first name length must be between 2 and 50 characters.")
    @NotNull
    private String lastName;

    @Size(min = 2, max = 100, message = "The address length must be between 2 and 50 characters.")
    private String address;

    @Past(message = "Date of birth must be in the past.")
    private LocalDate birthday;

    @Pattern(regexp = "^\\+.*", message = "Email must start with a '+' symbol.")
    @NotBlank(message = "phone number shouldn't have any whitespaces!")
    @Size(min = 6, max = 14, message = "The phone number length must be between 6 and 14 characters.")
    private String phoneNumber;
}
