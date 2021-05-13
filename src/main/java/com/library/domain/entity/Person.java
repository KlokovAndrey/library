package com.library.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Person extends EntityBase{
    @Column(name = "name")
    private String name;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "person")
    private Set<TakenBook> books;
}
