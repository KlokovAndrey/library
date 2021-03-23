package com.library.service;

import com.library.dto.BookFileDto;

public interface BookFileService {
    public BookFileDto findById(String id);
    public BookFileDto create(BookFileDto bookFileDto);
    public BookFileDto update(String id, BookFileDto bookFileDto);
    public void delete(String id);
}
