package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.BookDto;
import com.myBookSchelf.BookSchelf.exception.BookApiException;
import com.myBookSchelf.BookSchelf.exception.ResocurceNotFoundException;
import com.myBookSchelf.BookSchelf.model.Book;
import com.myBookSchelf.BookSchelf.model.User;
import com.myBookSchelf.BookSchelf.repository.BookRepository;
import com.myBookSchelf.BookSchelf.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;
    private ModelMapper mapper;
    private UserRepository userRepository;


    public BookServiceImpl(BookRepository bookRepository, ModelMapper mapper, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper=mapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto createBook(long id,BookDto bookDto) {

        if (bookRepository.existsByTitle(bookDto.getTitle()) && bookRepository.existsByUserId(id)){
            throw new BookApiException(HttpStatus.BAD_REQUEST, "Book alredy exists.");
        }
        Book book =dtoToEntity(bookDto);
        User user = userRepository.findById(id).orElseThrow(()
                -> new ResocurceNotFoundException("Book", "id", id));

        book.setUser(user);
        Book newBook = bookRepository.save(book);

        return maptoDto(newBook);
    }

    @Override
    public void delateBook(long userId, long bookId)  {
        User user = userRepository.findById(userId).orElseThrow(()
                -> new ResocurceNotFoundException("Book", "id", userId));
        Book book = bookRepository.findById(bookId).orElseThrow(()->
                new ResocurceNotFoundException("Book", "id", bookId));
        if(book.getUser().getId() != user.getId()){
            throw new BookApiException(HttpStatus.BAD_REQUEST,"Book dont belongs to your Shelf");
        }
        bookRepository.delete(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookDto> findedBooks =  bookRepository.findAll().stream().map(book -> maptoDto(book)).collect(Collectors.toList());
        return findedBooks;
    }

    @Override
    public List<BookDto> getBooksByuserId(long userId) {
        List<Book> books = bookRepository.findByUserId(userId);
     return books.stream().map(book -> maptoDto(book)).collect(Collectors.toList());
    }


    //ModelMaper
    private BookDto maptoDto(Book book){
        BookDto bookDto = mapper.map(book, BookDto.class);
        return bookDto;
    }
private Book dtoToEntity(BookDto bookDto){
        Book book = mapper.map(bookDto, Book.class);
        return book;
}
    }






