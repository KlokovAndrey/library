package com.library.service;

import com.library.dto.Book;
import com.library.dto.BookInfoDto;

import java.util.List;

public interface BookInfoService {

    public BookInfoDto findById(String id);
    public List<BookInfoDto> findByName(String name);
    public List<BookInfoDto> findByAuthor(String author);
    public Book create(Book book);
    public BookInfoDto update(String id, BookInfoDto bookInfoDto);
    public void delete(String id);
}
