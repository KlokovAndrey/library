package com.library.domain.entity;

import com.library.domain.enums.GenreType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Year;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book extends EntityBase{
    @Column(name = "name")
    private String name;
    @ManyToMany
    private Set<Author> author;
    @Column(name = "year_of_publishing")
    private Year yearOfPublishing;
    @Enumerated
    @Column(name = "genre")
    private GenreType genre;
    @Column(name = "number")
    private int number;
}
