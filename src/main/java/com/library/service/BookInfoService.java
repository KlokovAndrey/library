package com.library.service;

import com.library.domain.dto.BookDto;
import com.library.domain.dto.BookInfoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookInfoService {

    public BookInfoDto findById(String id);
    public List<BookInfoDto> findByName(String name);
    public List<BookInfoDto> findByAuthor(String author);
    public BookInfoDto create(BookDto bookDto, MultipartFile file);
    public BookInfoDto update(String id, BookDto bookDto);
    public BookInfoDto updateFile(String id, MultipartFile file);
    public BookInfoDto increaseNumber(String id);
    public BookInfoDto reduceNumber(String id);
    public void delete(String id);
}
