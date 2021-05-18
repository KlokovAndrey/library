package com.library.controller.exception;

public class PersonAlreadyExistsException extends RuntimeException {
    public PersonAlreadyExistsException() {
        super("A person with such email already exists");
    }
}
