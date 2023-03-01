package com.myBookSchelf.BookSchelf.repository;

import com.myBookSchelf.BookSchelf.model.Role;
import com.myBookSchelf.BookSchelf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository

public interface UserRepository extends JpaRepository<User, Long> {

 List<User> findByName(String username);
 Optional<User> findByEmail(String email);
 Optional<User> findByUsernameOrEmail(String name, String email);
// Optional<User> findByName(String name);

 Boolean existsByUsername(String name);
 Boolean existsByEmail(String email);

}