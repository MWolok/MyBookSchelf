package com.myBookSchelf.BookSchelf.exception;

import org.springframework.http.HttpStatus;

public class BookApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public BookApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BookApiException(String message, HttpStatus status, String newmessage) {
        super(message);
        this.status = status;
        this.message = newmessage;
    }
    public HttpStatus getStatus(){
        return status;
    }

    @Override
    public String getMessage(){
        return  message;
}

}
