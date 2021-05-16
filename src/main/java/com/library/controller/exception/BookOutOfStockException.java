package com.library.controller.exception;

public class BookOutOfStockException extends RuntimeException {
    public BookOutOfStockException() {super("Book is out of stock");}
}
