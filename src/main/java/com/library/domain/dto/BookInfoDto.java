package com.library.domain.dto;

import com.library.domain.enums.GenreType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookInfoDto extends BookDto {
    private int yearOfPublishing;
    private GenreType genre;
}
