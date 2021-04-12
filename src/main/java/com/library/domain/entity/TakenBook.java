package com.library.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.UUID;

@Entity
public class TakenBook {
    @Id
    private UUID id = UUID.randomUUID();
    private UUID personId;
    private UUID bookId;
    private Date dateOfReceiving;

}
