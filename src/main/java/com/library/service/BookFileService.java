package com.library.service;

import com.library.dto.BookFileDto;
import org.springframework.web.multipart.MultipartFile;

public interface BookFileService {
    public BookFileDto findById(String id);
    public BookFileDto create(String id, MultipartFile file);
    public BookFileDto update(String id, BookFileDto bookFileDto);
    public void delete(String id);
}
