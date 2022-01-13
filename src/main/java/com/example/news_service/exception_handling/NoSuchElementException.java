package com.example.news_service.exception_handling;

public class NoSuchElementException extends RuntimeException{

    public NoSuchElementException(String message){
        super(message);
    }
}
