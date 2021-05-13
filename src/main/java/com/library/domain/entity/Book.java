package com.library.domain.entity;

import com.library.domain.enums.GenreType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book extends EntityBase{
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

    @Column(name = "year_of_publishing")
    private int yearOfPublishing;
    @Enumerated
    @Column(name = "genre")
    private GenreType genre;
}
