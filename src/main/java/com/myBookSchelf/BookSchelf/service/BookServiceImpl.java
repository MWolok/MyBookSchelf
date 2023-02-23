package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.BookDto;
import com.myBookSchelf.BookSchelf.model.Book;
import com.myBookSchelf.BookSchelf.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;
    private ModelMapper mapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper mapper) {

        this.mapper=mapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
//        Book book = new Book();
//        book.setAuthor(bookDto.getAuthor());
//        book.setTitle(bookDto.getTitle());
    Book newBook = bookRepository.save(DtoToEntity(bookDto));
// BookDto bookResponse = new BookDto();
// bookResponse.setAuthor(newBook.getAuthor());
// bookResponse.setTitle(newBook.getTitle());
        return maptoDto(newBook);
    }

    @Override
    public List <BookDto> getBookBytitle(BookDto bookDto) {
           List<Book> bookFound = bookRepository.findByTitle(bookDto.getTitle());
        BookDto founded = new BookDto();
        List<BookDto> foundedDto = new ArrayList<>();
        if(!bookFound.isEmpty()){
founded.setTitle(bookDto.getTitle());
founded.setTitle(bookDto.getAuthor());
foundedDto.add(founded);
        return foundedDto;
    }
        return foundedDto;
}
//ModelMaper
    private BookDto maptoDto(Book book){
        BookDto bookDto = mapper.map(book, BookDto.class);
        return bookDto;
    }
private Book DtoToEntity(BookDto bookDto){
        Book book = mapper.map(bookDto, Book.class);
        return book;
}
    }






