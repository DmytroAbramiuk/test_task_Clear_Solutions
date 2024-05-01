package com.example.test_task_Clear_Solutions.api.service;

import com.example.test_task_Clear_Solutions.api.service.dto.UserDto;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface UserService {
    List<UserDto> listAll();
    UserDto create(UserDto dto);
    UserDto getById(Long id);
    UserDto update(UserDto dto);
    UserDto patch(UserDto dto);
    void delete(Long id);
    List<UserDto> search(LocalDate from, LocalDate to);
}
