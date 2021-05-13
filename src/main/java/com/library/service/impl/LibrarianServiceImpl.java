package com.library.service.impl;

import com.library.controller.exception.BookNotFoundException;
import com.library.controller.exception.PersonNotFoundException;
import com.library.domain.dto.BookInfoDto;
import com.library.domain.dto.PersonDto;
import com.library.domain.dto.TakenBookDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.Book;
import com.library.domain.entity.Person;
import com.library.domain.entity.TakenBook;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.PersonRepository;
import com.library.repository.TakenBookRepository;
import com.library.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static java.time.LocalTime.now;

@Service
@RequiredArgsConstructor
public class LibrarianServiceImpl implements LibrarianService {

    private final PersonRepository personRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final TakenBookRepository takenBookRepository;
    private final ConversionService conversionService;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = conversionService.convert(personDto, Person.class);
        Person result = personRepository.save(person);
        return conversionService.convert(result, PersonDto.class);
    }

    @Override
    public BookInfoDto createBook(BookInfoDto bookInfoDto) {
        Book book = conversionService.convert(bookInfoDto, Book.class);
        Set<Author> authors = book.getAuthors();
        for(Author author : authors){
            List<Author> found = authorRepository.findByName(author.getName());
            if(!found.isEmpty()){
                author.setId(found.get(0).getId());
            }
        }
        book.setAuthors(authors);
        Book result = bookRepository.save(book);
        return conversionService.convert(result, BookInfoDto.class);
    }

    @Override
    public TakenBookDto addBook(UUID personId, UUID bookId){
        Optional<Person> person = personRepository.findById(personId);
        if (person.isEmpty()) throw new PersonNotFoundException();
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isEmpty()) throw new BookNotFoundException();
        TakenBook takenBook = new TakenBook();
        takenBook.setPerson(person.get());
        takenBook.setBook(book.get());
        takenBook.setDateOfReceiving(LocalDate.now());
        TakenBook result = takenBookRepository.save(takenBook);
        return conversionService.convert(result, TakenBookDto.class);
    }

    @Override
    public void removeBook(UUID id){
        takenBookRepository.deleteById(id);
    }
}
