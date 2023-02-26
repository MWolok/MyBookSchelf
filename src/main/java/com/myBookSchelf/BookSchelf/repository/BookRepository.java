package com.myBookSchelf.BookSchelf.repository;

import com.myBookSchelf.BookSchelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
  List<Book> findByUserId(long userid) ;
  Boolean existsByTitle(String title);
  Boolean existsByUserId(long id);
}
