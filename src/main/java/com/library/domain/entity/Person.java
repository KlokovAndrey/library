package com.library.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
}
