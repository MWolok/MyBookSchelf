package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.BookDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    BookDto createBook(long userId,BookDto bookDto);
    void delateBook(long userId, long bookId);
    List<BookDto> getAllBooks();
    List<BookDto> getBooksByuserId(long userId);
}
