package com.library.service.impl;

import com.library.dto.BookInfoDto;
import com.library.dto.PersonDto;
import com.library.dto.TakenBookDto;
import com.library.service.PersonService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
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
    public TakenBookDto addBook(String personId, String bookId){
        return TakenBookDto.builder().dateOfReceiving(new Date(System.currentTimeMillis())).build();
    }

    @Override
    public void removeBook(String personId, String bookId){
    }

    @Override
    public List<TakenBookDto> isExpired(String personId){
        return null;
    }
}
