package com.example.test_task_Clear_Solutions.api.mapper;

import com.example.test_task_Clear_Solutions.api.data.entity.User;
import com.example.test_task_Clear_Solutions.api.request.CreateUserRequest;
import com.example.test_task_Clear_Solutions.api.request.PatchUserRequest;
import com.example.test_task_Clear_Solutions.api.request.UpdateUserRequest;
import com.example.test_task_Clear_Solutions.api.response.UserResponse;
import com.example.test_task_Clear_Solutions.api.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public List<UserDto> toUserDtos(Collection<User> users){
        return users.stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }
    public UserDto toUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthday(user.getBirthday())
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public List<UserResponse> toUserResponses(Collection<UserDto> dtos){
        return dtos.stream()
                .map(this::toUserResponse)
                .collect(Collectors.toList());
    }

    public UserResponse toUserResponse(UserDto dto){
        return UserResponse.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthday(dto.getBirthday())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    public UserDto toUserDto(CreateUserRequest request){
        return UserDto.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthday(request.getBirthday())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public User toUserEntity(UserDto dto){
        return User.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthday(dto.getBirthday())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    public UserDto toUserDto(UpdateUserRequest request){
        return UserDto.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthday(request.getBirthday())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public UserDto toUserDto(UpdateUserRequest request, Long id){
        return UserDto.builder()
                .id(id)
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthday(request.getBirthday())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public UserDto toUserDto(PatchUserRequest request, Long id){
        return UserDto.builder()
                .id(id)
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthday(request.getBirthday())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

}
