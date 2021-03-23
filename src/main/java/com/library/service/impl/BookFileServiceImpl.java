package com.library.service.impl;

import com.library.dto.BookFileDto;
import com.library.service.BookFileService;
import org.springframework.stereotype.Service;

@Service
public class BookFileServiceImpl implements BookFileService {
    @Override
    public BookFileDto findById(String id) {
        return BookFileDto.builder().id(id).build();
    }

    @Override
    public BookFileDto create(BookFileDto bookFileDto) {
        return bookFileDto;
    }

    @Override
    public BookFileDto update(String id, BookFileDto bookFileDto) {
        return bookFileDto;
    }

    @Override
    public void delete(String id) {

    }
}
