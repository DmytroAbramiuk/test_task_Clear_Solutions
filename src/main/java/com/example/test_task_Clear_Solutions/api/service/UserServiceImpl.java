package com.example.test_task_Clear_Solutions.api.service;

import com.example.test_task_Clear_Solutions.api.config.PropertyReader;
import com.example.test_task_Clear_Solutions.api.config.Validator;
import com.example.test_task_Clear_Solutions.api.data.entity.User;
import com.example.test_task_Clear_Solutions.api.data.repository.UserRepository;
import com.example.test_task_Clear_Solutions.api.exception.*;
import com.example.test_task_Clear_Solutions.api.mapper.UserMapper;
import com.example.test_task_Clear_Solutions.api.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserMapper mapper;
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<UserDto> listAll() {
        return mapper.toUserDtos(repository.findAll());
    }

    @Override
    public UserDto create(UserDto dto) {
        Validator.validateUser(dto);
        User newUser = mapper.toUserEntity(dto);
        newUser.setId(null);
        return mapper.toUserDto(repository.save(newUser));
    }

    @Override
    public UserDto getById(Long id) {
        return mapper.toUserDto(repository.getReferenceById(id));
    }

    @Override
    public UserDto update(UserDto dto) {
        Validator.validateUser(dto);
        UserDto toUpdate = getById(dto.getId());
        toUpdate.setEmail(dto.getEmail());
        toUpdate.setFirstName(dto.getFirstName());
        toUpdate.setLastName(dto.getLastName());
        toUpdate.setBirthday(dto.getBirthday());
        toUpdate.setAddress(dto.getAddress());
        toUpdate.setPhoneNumber(dto.getPhoneNumber());
        repository.save(mapper.toUserEntity(toUpdate));
        return toUpdate;
    }

    @Override
    public UserDto patch(UserDto dto) {
        UserDto userToPatch = getById(dto.getId());
        if (userToPatch == null) {
            return null;
        }
        if (dto.getEmail() != null) {
            userToPatch.setEmail(dto.getEmail());
        }
        if (dto.getFirstName() != null) {
            userToPatch.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            userToPatch.setLastName(dto.getLastName());
        }
        if (dto.getBirthday() != null) {
            userToPatch.setBirthday(dto.getBirthday());
        }
        if (dto.getAddress() != null) {
            userToPatch.setAddress(dto.getAddress());
        }
        if (dto.getPhoneNumber() != null) {
            userToPatch.setPhoneNumber(dto.getPhoneNumber());
        }

        Validator.validateUser(userToPatch);

        repository.save(mapper.toUserEntity(userToPatch));
        return userToPatch;
    }

    @Override
    public void delete(Long id) {
        User userToDelete = mapper.toUserEntity(getById(id));
        repository.delete(userToDelete);
    }

    @Override
    public List<UserDto> search(LocalDate from, LocalDate to) {
        Validator.validateSearchDates(from, to);
        return mapper.toUserDtos(repository.findOnRange(from, to));
    }
}
