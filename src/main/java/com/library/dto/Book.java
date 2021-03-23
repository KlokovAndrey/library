package com.library.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Year;

@Data
@Builder
public class Book {
    private String id;
    private String name;
    private String author;
    private Year yearOfPublishing;
    private GenreType genre;
    private int count;
    private String path;
}
