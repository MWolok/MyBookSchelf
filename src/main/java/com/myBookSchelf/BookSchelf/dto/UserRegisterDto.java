package com.myBookSchelf.BookSchelf.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    private String name;
    private  String password;
    private String username;
    private String email;
}
