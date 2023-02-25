package com.myBookSchelf.BookSchelf.controller;

import com.myBookSchelf.BookSchelf.dto.BookDto;
import com.myBookSchelf.BookSchelf.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
//    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        List<BookDto> found = bookService.getBookBytitle(bookDto);
if(!found.isEmpty()){
    found.clear();
    return new ResponseEntity (bookDto.getTitle(),HttpStatus.CONFLICT);

} else
return new ResponseEntity<>(bookService.createBook(bookDto), HttpStatus.CREATED);
   }
}
