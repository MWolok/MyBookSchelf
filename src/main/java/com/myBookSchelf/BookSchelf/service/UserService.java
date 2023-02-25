package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;

import java.util.List;

public interface UserService {
    List<UserRegisterDto> getAllUsers();
}
