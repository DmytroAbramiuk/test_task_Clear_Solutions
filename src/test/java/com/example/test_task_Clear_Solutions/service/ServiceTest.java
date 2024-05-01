package com.example.test_task_Clear_Solutions.service;

import com.example.test_task_Clear_Solutions.api.data.entity.User;
import com.example.test_task_Clear_Solutions.api.data.repository.UserRepository;
import com.example.test_task_Clear_Solutions.api.mapper.UserMapper;
import com.example.test_task_Clear_Solutions.api.service.UserServiceImpl;
import com.example.test_task_Clear_Solutions.api.service.dto.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetAllUsers() {
        List<User> userList = Arrays.asList(
                new User(
                        1L,
                        "email@email.com",
                        "Example",
                        "Example",
                        LocalDate.now(),
                        "Example",
                        "+380638652838"),
                new User(
                        2L,
                        "email@email.com",
                        "Example2",
                        "Example2",
                        LocalDate.now(),
                        "Example2",
                        "+380631111111")
        );

        List<UserDto> userDtos = Arrays.asList(
                new UserDto(
                        1L,
                        "email@email.com",
                        "Example",
                        "Example",
                        LocalDate.now(),
                        "Example",
                        "+380638652838"),
                new UserDto(
                        2L,
                        "email@email.com",
                        "Example2",
                        "Example2",
                        LocalDate.now(),
                        "Example2",
                        "+380631111111")
        );

        for(User u : userList){
            userRepository.save(u);
        }
        when(userService.listAll()).thenReturn(userDtos);

        List<UserDto> result = userService.listAll();

        Assertions.assertThat(userDtos).isEqualTo(result);
    }

    @Test
    void createTest(){
        User user = new User(
                1L,
                "email@email.com",
                "Example",
                "Example",
                LocalDate.now(),
                "Example",
                "+380638652838");

        UserDto dto = new UserDto(
                1L,
                "email@email.com",
                "Example",
                "Example",
                LocalDate.now(),
                "Example",
                "+380638652838"
        );

        when(userMapper.toUserDto(user)).thenReturn(dto);
        when(userMapper.toUserEntity(dto)).thenReturn(user);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        UserDto result = userService.create(dto);

        Assertions.assertThat(result).isNotNull();
    }

    @Test
    void getByIdTest(){
        User user = new User(
                1L,
                "email@email.com",
                "Example",
                "Example",
                LocalDate.now(),
                "Example",
                "+380638652838");

        userRepository.save(user);

        UserDto dto = new UserDto(
                1L,
                "email@email.com",
                "Example",
                "Example",
                LocalDate.now(),
                "Example",
                "+380638652838"
        );


        when(userService.getById(dto.getId())).thenReturn(dto);

        UserDto result = userService.getById(dto.getId());

        Assertions.assertThat(dto).isEqualTo(result);
    }

    @Test
    void updateTest(){
        User user = new User(
                1L,
                "email@email.com",
                "Example",
                "Example",
                LocalDate.now(),
                "Example",
                "+380638652838");

        userRepository.save(user);

        UserDto dto = new UserDto(
                1L,
                "email@email.com",
                "Example",
                "ExampleUpdated",
                LocalDate.now(),
                "Example",
                "+380638652838"
        );

        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        when(userMapper.toUserEntity(dto)).thenReturn(user);
        when(userService.getById(dto.getId())).thenReturn(dto);
        UserDto result = userService.update(dto);

        Assertions.assertThat(dto).isEqualTo(result);
    }

    @Test
    void patchTest(){
        User user = new User(
                1L,
                "email@email.com",
                "Example",
                "Example",
                LocalDate.now(),
                "Example",
                "+380638652838");

        userRepository.save(user);

        UserDto dto = new UserDto();
        dto.setLastName("ExamplePatched");

        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        when(userMapper.toUserEntity(dto)).thenReturn(user);
        when(userService.getById(dto.getId())).thenReturn(dto);
        UserDto result = userService.patch(dto);

        Assertions.assertThat(dto).isEqualTo(result);
    }

    @Test
    void deleteTest(){
        Long id = 1L;
        User user = new User(
                id,
                "email@email.com",
                "Example",
                "Example",
                LocalDate.now(),
                "Example",
                "+380638652838");

        userRepository.save(user);

        UserDto dto = new UserDto(
                id,
                "email@email.com",
                "Example",
                "ExampleUpdated",
                LocalDate.now(),
                "Example",
                "+380638652838"
        );


        when(userService.getById(id)).thenReturn(dto);
        when(userMapper.toUserEntity(dto)).thenReturn(user);
        doNothing().when(userRepository).delete(user);

        userService.delete(id);

        org.junit.jupiter.api.Assertions.assertAll(() -> userService.delete(id));
    }
}
