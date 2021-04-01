package com.library.dto;

import lombok.*;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    protected String id;
    protected String name;
    protected String author;
    protected Year yearOfPublishing;
    protected GenreType genre;

    public Book(Book book) {
        this.id = book.id;
        this.name = book.name;
        this.author = book.author;
        this.yearOfPublishing = book.yearOfPublishing;
        this.genre = book.genre;
    }


}
