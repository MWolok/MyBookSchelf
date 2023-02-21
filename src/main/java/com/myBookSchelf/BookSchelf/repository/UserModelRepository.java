package com.myBookSchelf.BookSchelf.repository;

import com.myBookSchelf.BookSchelf.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface UserModelRepository extends JpaRepository<UserModel, Long> {

 List<UserModel> findByName(String username);

}