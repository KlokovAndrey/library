package com.library.service;

import com.library.domain.dto.*;
import com.library.domain.entity.Warehouse;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface LibrarianService {

    PersonDto createPerson(PersonDto personDto);
    BookInfoWithPlaceDto createBook(BookInfoDto bookInfoDto);
    TakenBookWithPlaceDto addBook(UUID personId, UUID bookId);
    void removeBook(UUID id);
    Warehouse findWarehouseByBookId(UUID bookId);
    PersonDto findPersonByEmail(String email);
}
