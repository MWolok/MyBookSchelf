package com.myBookSchelf.BookSchelf.controller;

import com.myBookSchelf.BookSchelf.dto.UserDto;
import com.myBookSchelf.BookSchelf.model.User;
import com.myBookSchelf.BookSchelf.repository.UserRepository;
import com.myBookSchelf.BookSchelf.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //to refactor new way

    @PostMapping(path = "/register")
    public ResponseEntity registerUser(@RequestBody User user){
        List<User> userDB = userRepository.findByName(user.getName());
        if (!userDB.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/api/allusers")
    public List<UserDto> getAllUsers(){
        return  userService.getAllUsers();
    }

}
