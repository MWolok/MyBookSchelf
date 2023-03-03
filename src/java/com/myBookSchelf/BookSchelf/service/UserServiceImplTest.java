package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;
import com.myBookSchelf.BookSchelf.repository.UserRepository;
import com.myBookSchelf.BookSchelf.service.AuthoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

//@DataJpaTest
@Testcontainers
@SpringBootTest
//@ContextConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceImplTest {
@Container
    MySQLContainer mySQLContainer = new MySQLContainer<>("mysql:latest")
        .withDatabaseName("test-db")
        .withUsername("test")
        .withPassword("pass");

@Autowired
private UserServiceImpl userService;
@Autowired
private AuthoService authoService;
@Autowired
private UserRepository userRepository;

UserRegisterDto userRegisterDto = new UserRegisterDto("test","test","test1","test1");
    @Test void registertest(){
        authoService.register(userRegisterDto);
        Assertions.assertTrue(userRepository.existsByEmail("test1"));
    }

    @Test
    void getAllUserstest() {
       Assertions.assertTrue(userService.getAllUsers().size() >0);
    }
}