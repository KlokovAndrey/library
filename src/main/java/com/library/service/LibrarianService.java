package com.library.service;

import com.library.domain.dto.BookInfoDto;
import com.library.domain.dto.PersonDto;
import com.library.domain.dto.TakenBookDto;

import java.util.UUID;

public interface LibrarianService {

    PersonDto createPerson(PersonDto personDto);
    BookInfoDto createBook(BookInfoDto bookInfoDto);
    TakenBookDto addBook(UUID personId, UUID bookId);
    void removeBook(UUID id);

}
