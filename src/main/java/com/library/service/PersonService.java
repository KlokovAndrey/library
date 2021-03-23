package com.library.service;

import com.library.dto.BookInfoDto;
import com.library.dto.PersonDto;

import java.util.List;

public interface PersonService {

    public PersonDto findById(String id);
    public List<PersonDto> findByName(String name);
    public PersonDto create(PersonDto personDto);
    public PersonDto update(String id, PersonDto personDto);
    public void delete(String id);
    public void addBook(String personId, String bookId);
    public void removeBook(String personId, String bookId);
}
