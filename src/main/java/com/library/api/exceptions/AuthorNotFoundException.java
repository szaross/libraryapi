package com.library.api.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String msg){
        super(msg);
    }
}
