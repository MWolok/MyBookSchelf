package com.myBookSchelf.BookSchelf.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@NonNull
    private String name;
@NonNull
    private  String password;
@NonNull
    private String email;
}
