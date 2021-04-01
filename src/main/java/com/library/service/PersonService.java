package com.library.service;

import com.library.dto.BookInfoDto;
import com.library.dto.PersonDto;
import com.library.dto.TakenBookDto;

import java.util.List;

public interface PersonService {

    public PersonDto findById(String id);
    public List<PersonDto> findByName(String name);
    public PersonDto create(PersonDto personDto);
    public PersonDto update(String id, PersonDto personDto);
    public void delete(String id);
    public TakenBookDto addBook(String personId, String bookId);
    public void removeBook(String personId, String bookId);
    public List<TakenBookDto> isExpired(String personId);
}
