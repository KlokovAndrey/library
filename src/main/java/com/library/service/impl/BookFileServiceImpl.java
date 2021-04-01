package com.library.service.impl;

import com.library.dto.BookFileDto;
import com.library.service.BookFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BookFileServiceImpl implements BookFileService {
    @Override
    public BookFileDto findById(String id) {
        return BookFileDto.builder().id(id).build();
    }

    @Override
    public BookFileDto create(String id, MultipartFile file) {
        return BookFileDto.builder().id(id).file(file).build();
    }

    @Override
    public BookFileDto update(String id, BookFileDto bookFileDto) {
        return bookFileDto;
    }

    @Override
    public void delete(String id) {

    }
}
