package com.library.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
@Data
@Builder
public class TakenBookDto extends BookDto {
    private Date dateOfReceiving;
}
