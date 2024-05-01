package com.example.test_task_Clear_Solutions.repository;

import com.example.test_task_Clear_Solutions.api.data.entity.User;
import com.example.test_task_Clear_Solutions.api.data.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class RepositoryTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");
    @Autowired
    private UserRepository repository;

    @Test
    void searchQueryTest(){
        LocalDate from = LocalDate.of(1999,1,1);
        LocalDate to = LocalDate.of(2005,1,1);
        List<User> userList = Arrays.asList(
                new User(
                        1L,
                        "email@email.com",
                        "Example",
                        "Example",
                        LocalDate.of(2014, 1,1),
                        "Example",
                        "+380638652838"),
                new User(
                        2L,
                        "email@email.com",
                        "Example2",
                        "Example2",
                        LocalDate.of(2000, 1,1),
                        "Example2",
                        "+380631111111")
        );

        for(User u : userList){
            repository.save(u);
        }

        Collection<User> result = repository.findOnRange(from, to);

        Assertions.assertEquals(result.size(),1);
    }
}
