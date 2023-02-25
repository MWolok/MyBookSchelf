package com.myBookSchelf.BookSchelf.controller;

import com.myBookSchelf.BookSchelf.dto.LoginDto;
import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;
import com.myBookSchelf.BookSchelf.service.AuthoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthCotroller {
    private AuthoService authoService;

    public AuthCotroller(AuthoService authoService) {
        this.authoService = authoService;
    }
    //Login api
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
     String response =   authoService.login(loginDto);
     return  ResponseEntity.ok(response);
    }
@PostMapping("/register")
public ResponseEntity<String> register(@RequestBody UserRegisterDto registerDto){
    String response = authoService.register(registerDto);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
}

}
