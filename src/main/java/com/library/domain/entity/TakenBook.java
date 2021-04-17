package com.library.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.UUID;

@Entity
public class TakenBook extends EntityBase{
    @Column(name = "person_id")
    private UUID personId;
    @Column(name = "book_id")
    private UUID bookId;
    @Column(name = "date_of_receiving")
    private Date dateOfReceiving;

}
