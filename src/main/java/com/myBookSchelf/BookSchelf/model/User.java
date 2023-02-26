package com.myBookSchelf.BookSchelf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
    private long id;

    private String name;
@Column(nullable = false, unique = true)
private String username;
@NonNull
    private  String password;
@Column(nullable = false, unique = true)
//@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String email;


@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(name = "users_roles", joinColumns= @JoinColumn(name = "user_id", referencedColumnName ="id"),
inverseJoinColumns = @JoinColumn (name = "role_id", referencedColumnName = "id"))
private Set<Role> roles;


@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

}

