package com.myBookSchelf.BookSchelf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private  long id;
    private String usernameOrEmail;
    private String password;
}
