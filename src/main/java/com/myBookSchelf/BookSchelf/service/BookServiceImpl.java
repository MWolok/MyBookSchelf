package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.BookDto;
import com.myBookSchelf.BookSchelf.model.Book;
import com.myBookSchelf.BookSchelf.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
    Book newBook = bookRepository.save(book);
 BookDto bookResponse = new BookDto();

 bookResponse.setAuthor(newBook.getAuthor());
 bookResponse.setTitle(newBook.getTitle());
        return bookResponse;
    }

    @Override
    public BookDto getBookBytitle(String title) {
       Book book = bookRepository.findByTitle(title);
BookDto newbook = new BookDto();
newbook.setTitle();

        return null;
    }
}
