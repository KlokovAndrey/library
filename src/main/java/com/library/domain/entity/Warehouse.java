package com.library.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehouse")
public class Warehouse extends EntityBase{
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private int row;
    private int shelf;
    private int number;
}
