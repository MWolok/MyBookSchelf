package com.myBookSchelf.BookSchelf.controller;

import com.myBookSchelf.BookSchelf.dto.BookDto;
import com.myBookSchelf.BookSchelf.model.Book;
import com.myBookSchelf.BookSchelf.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){

return new ResponseEntity<>(bookService.createBook(bookDto), HttpStatus.CREATED);
    }
}
