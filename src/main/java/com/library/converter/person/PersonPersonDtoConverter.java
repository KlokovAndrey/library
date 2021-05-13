package com.library.converter.person;

import com.library.domain.dto.AddressDto;
import com.library.domain.dto.PersonDto;
import com.library.domain.dto.TakenBookDto;
import com.library.domain.entity.Person;
import com.library.domain.entity.TakenBook;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PersonPersonDtoConverter implements Converter<Person, PersonDto> {

    private final ConversionService conversionService;

    @Override
    public PersonDto convert(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setAddress(conversionService.convert(person.getAddress(), AddressDto.class));
        Set<TakenBook> books = person.getBooks();
        if(person.getBooks()!=null) {
            List<TakenBookDto> booksDto = new LinkedList<>();
            for (TakenBook book : books) {
                booksDto.add(conversionService.convert(book, TakenBookDto.class));
            }
            personDto.setBooks(booksDto);
        } else{
            personDto.setBooks(new LinkedList<>());
        }
        return  personDto;
    }
}
