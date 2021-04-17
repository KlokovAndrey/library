package com.library.domain.dto;

import com.library.domain.enums.GenreType;
import lombok.*;

import java.time.Year;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    protected String id;
    protected String name;
    protected List<AuthorDto> author;
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
