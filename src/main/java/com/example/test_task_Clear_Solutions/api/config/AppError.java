package com.example.test_task_Clear_Solutions.api.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppError {
    private int errorCode;
    private String message;
}