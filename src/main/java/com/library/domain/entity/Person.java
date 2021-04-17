package com.library.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person extends EntityBase{
    @Column(name = "name")
    private String name;
}
