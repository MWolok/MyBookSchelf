package com.myBookSchelf.BookSchelf.controller;

import com.myBookSchelf.BookSchelf.dto.LoginDto;
import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;
import com.myBookSchelf.BookSchelf.service.AuthoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthCotroller {
    private AuthoService authoService;

    public AuthCotroller(AuthoService authoService) {
        this.authoService = authoService;
    }
    //Login api
    @PostMapping("/login")
    public ResponseEntity<Optional<Long>> login(@RequestBody LoginDto loginDto){
    Optional<Long> response =   authoService.login(loginDto);
     return  ResponseEntity.ok(response);
    }
    @CrossOrigin
@PostMapping("/register/adduser")
public ResponseEntity<String> register(@RequestBody UserRegisterDto registerDto){
    String response = authoService.register(registerDto);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
}

}
