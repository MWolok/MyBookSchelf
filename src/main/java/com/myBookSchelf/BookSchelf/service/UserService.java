package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
}
