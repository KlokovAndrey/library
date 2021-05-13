package com.library.controller.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException() {
        super("Person is not found");
    }
}
