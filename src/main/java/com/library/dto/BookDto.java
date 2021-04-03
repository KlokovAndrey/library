package com.library.dto;

import lombok.*;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    protected String id;
    protected String name;
    protected String author;
    protected Year yearOfPublishing;
    protected GenreType genre;

    public BookDto(BookDto bookDto) {
        this.id = bookDto.id;
        this.name = bookDto.name;
        this.author = bookDto.author;
        this.yearOfPublishing = bookDto.yearOfPublishing;
        this.genre = bookDto.genre;
    }


}
