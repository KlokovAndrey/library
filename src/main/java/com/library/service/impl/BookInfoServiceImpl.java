package com.library.service.impl;

import com.library.dto.Book;
import com.library.dto.BookInfoDto;
import com.library.service.BookInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Override
    public BookInfoDto findById(String id) {
        BookInfoDto bookInfoDto = new BookInfoDto();
        bookInfoDto.setId(id);
        return bookInfoDto;
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
    public BookInfoDto create(Book book, MultipartFile file) {
        return BookInfoDto.builder().build();
    }

    @Override
    public BookInfoDto update(String id, BookInfoDto bookInfoDto) {
        return bookInfoDto;
    }

    @Override
    public void delete(String id) {

    }
}
