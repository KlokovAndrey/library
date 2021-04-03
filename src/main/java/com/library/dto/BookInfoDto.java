package com.library.dto;

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
    private String fileId;
    private int number;

    public BookInfoDto(String id, String name, String author, Year yearOfPublishing, GenreType genre, int count, String fileId) {
        super(id, name, author, yearOfPublishing, genre);
        this.fileId = fileId;
    }

    public BookInfoDto(BookDto bookDto, String fileId) {
        super(bookDto);
        this.fileId = fileId;
    }



}
