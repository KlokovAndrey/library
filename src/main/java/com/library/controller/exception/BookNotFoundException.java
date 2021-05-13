package com.library.controller.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book is not found");
    }
}
