package com.library.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
@Data
@Builder
public class TakenBookDto extends Book{
    private Date dateOfReceiving;
}
