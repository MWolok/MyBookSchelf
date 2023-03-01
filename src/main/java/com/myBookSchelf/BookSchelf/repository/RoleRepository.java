package com.myBookSchelf.BookSchelf.repository;

import com.myBookSchelf.BookSchelf.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>
{
Optional<Role> findByName(String name);

}
