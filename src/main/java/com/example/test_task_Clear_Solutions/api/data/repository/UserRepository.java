package com.example.test_task_Clear_Solutions.api.data.repository;

import com.example.test_task_Clear_Solutions.api.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT id, email, first_name, last_name, birthday, address, phone_number FROM users WHERE birthday BETWEEN :from AND :to", nativeQuery = true)
    Collection<User> findOnRange(@Param("from") LocalDate from, @Param("to") LocalDate to);
}
