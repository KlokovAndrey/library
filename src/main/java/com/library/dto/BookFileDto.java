package com.library.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class BookFileDto {
    private String id;
    MultipartFile file;
}
