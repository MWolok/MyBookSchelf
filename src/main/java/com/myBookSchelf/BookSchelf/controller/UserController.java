package com.myBookSchelf.BookSchelf.controller;

import com.myBookSchelf.BookSchelf.dto.UserDto;
import com.myBookSchelf.BookSchelf.model.UserModel;
import com.myBookSchelf.BookSchelf.repository.UserModelRepository;
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
    public UserController(UserService userService, UserModelRepository userModelRepository) {
        this.userService = userService;
        this.userModelRepository = userModelRepository;
    }
    private UserModelRepository userModelRepository;
    private UserService userService;

    //to refactor new way

    @PostMapping(path = "/register")
    public ResponseEntity registerUser(@RequestBody UserModel userModel){
        List<UserModel> userDB = userModelRepository.findByName(userModel.getName());
        if (!userDB.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }UserModel newUser = userModelRepository.save(userModel);
        return ResponseEntity.ok(newUser);
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/api/allusers")
    public List<UserDto> getAllUsers(){
        return  userService.getAllUsers();
    }

}
