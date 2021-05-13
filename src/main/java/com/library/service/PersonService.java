package com.library.service;

import com.library.domain.dto.BookDto;
import com.library.domain.dto.BookInfoDto;
import com.library.domain.dto.PersonDto;
import com.library.domain.dto.TakenBookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    public BookInfoDto findBookById(UUID id);
    public List<BookDto> findBookByName(String name);
    public List<BookDto> findBookByAuthor(UUID author_id);
    //public List<BookDto> findBookByGenre(String genre);
    public Page<BookDto> findBookByGenre(String genre, Pageable pageable);
    public List<TakenBookDto> findAllTakenBook(UUID id);
    public List<TakenBookDto> isExpired(UUID  personId);
}
