package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.LoginDto;
import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;

public interface AuthoService {
    String login(LoginDto loginDto);

    String register(UserRegisterDto registerDto);
}
