package com.library.controller.handler;

import com.library.controller.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHandlerExample {

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlePersonNotFoundException(PersonNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleAuthorNotFoundException(AuthorNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleBookNotFoundException(BookNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(BookOutOfStockException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleBookOutOfStockException(BookOutOfStockException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(PersonAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handlePersonAlreadyExistsException(PersonAlreadyExistsException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleBookAlreadyExistsException(BookAlreadyExistsException exception) {
        return exception.getMessage();
    }
}
