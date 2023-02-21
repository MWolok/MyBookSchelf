package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.BookDto;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    BookDto getBookBytitle(String title);
}
