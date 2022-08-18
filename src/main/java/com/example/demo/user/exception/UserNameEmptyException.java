package com.example.demo.user.exception;

public class UserNameEmptyException extends RuntimeException{
    public UserNameEmptyException(String s){
        super(s);
    }
}
