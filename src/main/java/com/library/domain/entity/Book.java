package com.library.domain.entity;

import com.library.domain.enums.GenreType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.Year;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Book {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private String author;
    private Year yearOfPublishing;
    @Enumerated
    private GenreType genre;
    private int number;
}
