package com.library.controller.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException() {super("Author not found");}
}
