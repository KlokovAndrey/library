package com.library.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "warehouse")
public class Warehouse extends EntityBase{
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    int row;
    int shelf;
    int number;
}
