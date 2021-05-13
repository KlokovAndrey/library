package com.library.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address{
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String house;
    @Column
    private String flat;
}