package com.myBookSchelf.BookSchelf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    @Column(name = "user_id")
    private int id;
@NonNull
    private String name;
@NonNull
    private  String password;
@NonNull
@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String email;

@OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL, orphanRemoval = true)
private Set<Book> books = new HashSet<>();
}
