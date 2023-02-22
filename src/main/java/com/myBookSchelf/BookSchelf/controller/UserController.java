package com.myBookSchelf.BookSchelf.controller;

import com.myBookSchelf.BookSchelf.model.UserModel;
import com.myBookSchelf.BookSchelf.repository.UserModelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    UserModelRepository userModelRepository;
    public UserController(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }
    //to refactor new way
    @PostMapping(path = "/register")
    public ResponseEntity registerUser(@RequestBody UserModel userModel){
        List<UserModel> userDB = userModelRepository.findByName(userModel.getName());
        if (!userDB.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }UserModel newUser = userModelRepository.save(userModel);
        return ResponseEntity.ok(newUser);
    }
}
