package com.example.test_task_Clear_Solutions.api.controller;

import com.example.test_task_Clear_Solutions.api.mapper.UserMapper;
import com.example.test_task_Clear_Solutions.api.request.CreateUserRequest;
import com.example.test_task_Clear_Solutions.api.request.PatchUserRequest;
import com.example.test_task_Clear_Solutions.api.request.UpdateUserRequest;
import com.example.test_task_Clear_Solutions.api.response.UserResponse;
import com.example.test_task_Clear_Solutions.api.service.UserService;
import com.example.test_task_Clear_Solutions.api.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> userList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.toUserResponses(userService.listAll()));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.toUserResponse(userService.getById(id)));
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        UserDto dto = mapper.toUserDto(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toUserResponse(userService.create(dto)));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequest request) {
        UserDto dto = mapper.toUserDto(request, id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(mapper.toUserResponse(userService.update(dto)));
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<UserResponse> patchUser(@PathVariable("id") Long id, @RequestBody PatchUserRequest request) {
        UserDto userToPatch = mapper.toUserDto(request, id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(mapper.toUserResponse(userService.patch(userToPatch)));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/users/searchbydate")
    public ResponseEntity<List<UserResponse>> searchUsersByDateRange(
            @RequestParam("from") LocalDate from,
            @RequestParam("to") LocalDate to) {


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper
                        .toUserResponses(userService
                                .search(from,to)
                        )
                );
    }
}
