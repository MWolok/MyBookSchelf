package com.myBookSchelf.BookSchelf.controller;

import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;
import com.myBookSchelf.BookSchelf.model.User;
import com.myBookSchelf.BookSchelf.repository.UserRepository;
import com.myBookSchelf.BookSchelf.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    private UserRepository userRepository;
    private UserService userService;


    @PreAuthorize("hasRole('USER')")
    @GetMapping(path = "/api/allusers")
    public List<UserRegisterDto> getAllUsers(){
        return  userService.getAllUsers();
    }

}
