package com.myBookSchelf.BookSchelf.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserService {
    @Autowired
    UserModelRepository userModelRepository;
    @Autowired
    ObjectMapper objectMapper;

@PostMapping(path = "/register")
    public ResponseEntity registerUser(@RequestBody UserModel userModel){
        List<UserModel> userDB = userModelRepository.findByName(userModel.getName());
        if (!userDB.isEmpty()){
return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }UserModel newUser = userModelRepository.save(userModel);
       return ResponseEntity.ok(newUser);
    }
}
