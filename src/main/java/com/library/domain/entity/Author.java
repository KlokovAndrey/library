package com.library.domain.entity;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Table(name = "author")
public class Author extends EntityBase{

    @Column(name = "name")
    String name;
    @ManyToMany
    Set<Book> books;
}
