package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
   List<BookDto> getBookBytitle(BookDto bookDto);
}
