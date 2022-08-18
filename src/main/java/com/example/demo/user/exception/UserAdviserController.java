package com.example.demo.user.exception;

import com.example.demo.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAdviserController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFound(UserNotFoundException e){
        ErrorResponse response = new ErrorResponse();
        String message = "No user "+ e.getMessage() +" found";
        response.setError(message);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserEmptyException.class)
    public ResponseEntity<ErrorResponse> userEmpty(UserEmptyException e){
        ErrorResponse response = new ErrorResponse();
        String message = "User Entity Empty";
        response.setError(message);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNameEmptyException.class)
    public ResponseEntity<ErrorResponse> userNameEmpty(UserNameEmptyException e){
        ErrorResponse response = new ErrorResponse();
        String message = "User Name is Empty";
        response.setError(message);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserEmailEmptyException.class)
    public ResponseEntity<ErrorResponse> userEmailEmpty(UserEmailEmptyException e){
        ErrorResponse response = new ErrorResponse();
        String message = "User Email is Empty";
        response.setError(message);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
