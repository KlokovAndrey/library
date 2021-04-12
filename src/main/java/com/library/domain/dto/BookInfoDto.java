package com.library.domain.dto;

import com.library.domain.enums.GenreType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookInfoDto extends BookDto {
    BookFileDto file;
    private int number;

    public BookInfoDto(String id, String name, String author, Year yearOfPublishing, GenreType genre, int count, BookFileDto file, int number) {
        super(id, name, author, yearOfPublishing, genre);
        this.file = file;
        this.number = number;
    }

    public BookInfoDto(BookDto bookDto, BookFileDto file) {
        super(bookDto);
        this.file = file;
    }
}
