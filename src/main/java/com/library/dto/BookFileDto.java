package com.library.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookFileDto {
    private String id;
    private String path;
}