package com.library.service.impl;

import com.library.dto.Book;
import com.library.dto.BookInfoDto;
import com.library.service.BookInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Override
    public BookInfoDto findById(String id) {
        return BookInfoDto.builder().id(id).build();
    }

    @Override
    public List<BookInfoDto> findByName(String name) {
        return null;
    }

    @Override
    public List<BookInfoDto> findByAuthor(String author) {
        return null;
    }

    @Override
    public Book create(Book book) {
        return book;
    }

    @Override
    public BookInfoDto update(String id, BookInfoDto bookInfoDto) {
        return bookInfoDto;
    }

    @Override
    public void delete(String id) {

    }
}
