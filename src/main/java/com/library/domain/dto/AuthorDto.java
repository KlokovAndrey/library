package com.library.domain.dto;

import lombok.Data;
import java.util.List;

@Data
public class AuthorDto {
    private String id;
    private String name;
    private List<BookInfoDto> books;
}
