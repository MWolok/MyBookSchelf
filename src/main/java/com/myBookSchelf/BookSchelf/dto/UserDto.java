package com.myBookSchelf.BookSchelf.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String name;
    private  String password;

    private String email;
}
