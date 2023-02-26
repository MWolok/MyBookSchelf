package com.myBookSchelf.BookSchelf.controller;

import com.myBookSchelf.BookSchelf.dto.BookDto;
import com.myBookSchelf.BookSchelf.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {

        this.bookService = bookService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/api/{userId}/books")
    public ResponseEntity<BookDto> createBook(@PathVariable(value = "userId") long userId,@RequestBody BookDto bookDto){

        return  new ResponseEntity<>(bookService.createBook(userId,bookDto), HttpStatus.CREATED);
   }
   @GetMapping("/api/{userId}/allbooks")
   public List<BookDto> getBooksByUserId(@PathVariable(value = "userId") long userId){
        return bookService.getBooksByuserId(userId);

   }
   @DeleteMapping("api/{userdId}/books/{bookId}")
    public ResponseEntity<String>  delateBook(@PathVariable long userId, long bookId){
    bookService.delateBook(userId,bookId);
    return new ResponseEntity<>("Book delated", HttpStatus.OK);
    }


}
