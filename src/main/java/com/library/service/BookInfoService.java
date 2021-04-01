package com.library.service;

import com.library.dto.Book;
import com.library.dto.BookInfoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookInfoService {

    public BookInfoDto findById(String id);
    public List<BookInfoDto> findByName(String name);
    public List<BookInfoDto> findByAuthor(String author);
    public BookInfoDto create(Book book, MultipartFile file);
    public BookInfoDto update(String id, BookInfoDto bookInfoDto);
    public void delete(String id);
}
