package com.library.domain.dto;

import com.library.domain.enums.GenreType;
import lombok.*;

import java.time.Year;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    protected UUID id;
    protected String name;
    protected List<AuthorDto> authors;
}
