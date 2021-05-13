package com.library.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class TakenBook extends EntityBase{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "date_of_receiving")
    private LocalDate dateOfReceiving;

}
