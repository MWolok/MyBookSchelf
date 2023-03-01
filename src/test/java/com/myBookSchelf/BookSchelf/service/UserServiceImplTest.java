package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;
import com.myBookSchelf.BookSchelf.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
@DataJpaTest
class UserServiceImplTest {
    @Autowired
    private UserRepository userRepository;

//todo tests
    @Test
    void getAllUsers() {
      UserService userServiceMock= mock(UserService.class);
      userServiceMock.getAllUsers();

    }

}