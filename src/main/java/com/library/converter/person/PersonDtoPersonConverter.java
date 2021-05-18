package com.library.converter.person;

import com.library.domain.dto.AddressDto;
import com.library.domain.dto.PersonDto;
import com.library.domain.entity.Address;
import com.library.domain.entity.Person;
import com.library.domain.entity.TakenBook;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonDtoPersonConverter implements Converter<PersonDto, Person> {
    private final ConversionService conversionService;
    @Override
    public Person convert(PersonDto personDto) {
        Person person = new Person();
        //person.setId(personDto.getId());
        person.setEmail(personDto.getEmail());
        person.setName(personDto.getName());
        person.setAddress(conversionService.convert(personDto.getAddress(), Address.class));
//        person.setBooks(personDto.getBooks()
//                .stream()
//                .map(book -> conversionService.convert(book, TakenBook.class))
//                .collect(Collectors.toSet()));
        return person;
    }
}
