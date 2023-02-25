package com.myBookSchelf.BookSchelf.repository;

import com.myBookSchelf.BookSchelf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository

public interface UserRepository extends JpaRepository<User, Long> {

 List<User> findByName(String username);
 Optional<User> findByEmail(String email);
 Optional<User> findByNameOrEmail(String name, String email);
// Optional<User> findByName(String name);
 Boolean existByName(String name);
 Boolean existsByEmail(String email);

}