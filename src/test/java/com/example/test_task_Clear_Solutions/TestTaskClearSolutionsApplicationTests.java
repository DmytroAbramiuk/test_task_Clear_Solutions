package com.example.test_task_Clear_Solutions;

import com.example.test_task_Clear_Solutions.api.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TestTaskClearSolutionsApplicationTests {
	@Container
	@ServiceConnection
	static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");

	@Autowired
	private UserController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
