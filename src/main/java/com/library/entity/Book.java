package com.library.entity;

import com.library.dto.GenreType;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Year;
import java.util.UUID;

@Entity
public class Book {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private String author;
    private Year yearOfPublishing;
    private GenreType genre;
}
