package com.myBookSchelf.BookSchelf.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myBookSchelf.BookSchelf.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.myBookSchelf.BookSchelf.repository.UserModelRepository;

import java.util.List;

@RestController
public class UserService {
    UserModelRepository userModelRepository;
    public UserService(UserModelRepository userModelRepository) {
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
