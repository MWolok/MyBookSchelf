package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.LoginDto;
import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;

import java.util.Optional;

public interface AuthoService {
    Optional<Long> login(LoginDto loginDto);
    String userRole(long id);
    String register(UserRegisterDto registerDto);
}
