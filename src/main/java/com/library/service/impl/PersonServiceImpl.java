package com.library.service.impl;

import com.library.dto.BookInfoDto;
import com.library.dto.PersonDto;
import com.library.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public PersonDto findById(String id) {
        return PersonDto.builder().id(id).build();
    }

    @Override
    public List<PersonDto> findByName(String name) {
        return null;
    }

    @Override
    public PersonDto create(PersonDto personDto) {
        return personDto;
    }

    @Override
    public PersonDto update(String id, PersonDto personDto) {
        return personDto;
    }

    @Override
    public void delete(String id) {
    }

    @Override
    public void addBook(String personId, String bookId){
    }

    @Override
    public void removeBook(String personId, String bookId){
    }
}
