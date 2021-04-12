package com.library.service.impl;

import com.library.domain.dto.BookDto;
import com.library.domain.dto.BookInfoDto;
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
    public BookInfoDto create(BookDto bookDto, MultipartFile file) {
        return BookInfoDto.builder().build();
    }

    @Override
    public BookInfoDto update(String id, BookDto bookDto) {
        return BookInfoDto.builder().build();
    }

    @Override
    public BookInfoDto updateFile(String bookId, MultipartFile file) {
        return BookInfoDto.builder().build();
    }

    @Override
    public BookInfoDto increaseNumber(String id) {
        return BookInfoDto.builder().build();
    }

    @Override
    public BookInfoDto reduceNumber(String id) {
        return BookInfoDto.builder().build();
    }

    @Override
    public void delete(String id) {

    }
}
