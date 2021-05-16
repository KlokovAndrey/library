package com.library.controller.handler;

import com.library.controller.exception.AuthorNotFoundException;
import com.library.controller.exception.BookNotFoundException;
import com.library.controller.exception.BookOutOfStockException;
import com.library.controller.exception.PersonNotFoundException;
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
}
