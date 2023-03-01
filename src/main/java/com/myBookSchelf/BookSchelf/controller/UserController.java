package com.myBookSchelf.BookSchelf.controller;

import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;
import com.myBookSchelf.BookSchelf.model.User;
import com.myBookSchelf.BookSchelf.repository.UserRepository;
import com.myBookSchelf.BookSchelf.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class UserController {
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    private UserRepository userRepository;
    private UserService userService;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/api/allusers")
    public List<UserRegisterDto> getAllUsers(){
        return  userService.getAllUsers();
    }

}
