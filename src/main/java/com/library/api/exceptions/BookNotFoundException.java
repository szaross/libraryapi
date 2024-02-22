package com.library.api.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String msg){
        super(msg);
    }
}
