package com.example.demo.user.exception;

public class UserEmailEmptyException extends RuntimeException{
    public UserEmailEmptyException(String s){
        super(s);
    }
}
