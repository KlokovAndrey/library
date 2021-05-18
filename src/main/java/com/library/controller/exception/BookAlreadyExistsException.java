package com.library.controller.exception;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException() {super("Book already exists");}
}
