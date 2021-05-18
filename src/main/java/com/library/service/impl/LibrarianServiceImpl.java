package com.library.service.impl;

import com.library.controller.exception.BookAlreadyExistsException;
import com.library.controller.exception.BookNotFoundException;
import com.library.controller.exception.BookOutOfStockException;
import com.library.controller.exception.PersonNotFoundException;
import com.library.domain.dto.*;
import com.library.domain.entity.*;
import com.library.repository.*;
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
    private final WarehouseRepository warehouseRepository;
    private final ConversionService conversionService;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = conversionService.convert(personDto, Person.class);
        Person result = personRepository.save(person);
        return conversionService.convert(result, PersonDto.class);
    }

    @Override
    public BookInfoWithPlaceDto createBook(BookInfoDto bookInfoDto) {
        Optional<Book> foundBook = bookRepository.findByNameAndAuthorsName(bookInfoDto.getName(), bookInfoDto.getAuthors().get(0).getName());
        Book book = conversionService.convert(bookInfoDto, Book.class);
        if(!foundBook.isEmpty()) throw new BookAlreadyExistsException();
        Set<Author> authors = book.getAuthors();
        for(Author author : authors){
            List<Author> found = authorRepository.findByName(author.getName());
            if(!found.isEmpty()){
                author.setId(found.get(0).getId());
            }
        }
        book.setAuthors(authors);
        Book result = bookRepository.save(book);
        Warehouse warehouse = new Warehouse(result, (int)(1+Math.random()*20), (int)(1+Math.random()*20), 1);
        Warehouse warehouseResult = warehouseRepository.save(warehouse);
        return conversionService.convert(result, BookInfoWithPlaceDto.class);
    }

    @Override
    public TakenBookWithPlaceDto addBook(UUID personId, UUID bookId){
        Optional<Person> person = personRepository.findById(personId);
        if (person.isEmpty()) throw new PersonNotFoundException();
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isEmpty()) throw new BookNotFoundException();
        if(warehouseRepository.getNumber(bookId) < 1) throw new BookOutOfStockException();
        TakenBook takenBook = new TakenBook();
        takenBook.setPerson(person.get());
        takenBook.setBook(book.get());
        takenBook.setDateOfReceiving(LocalDate.now());
        TakenBook result = takenBookRepository.save(takenBook);
        warehouseRepository.decreaseNumber(bookId);
        return conversionService.convert(result, TakenBookWithPlaceDto.class);
    }

    @Override
    public void removeBook(UUID id){
        Optional<TakenBook> takenBook = takenBookRepository.findById(id);
        if (takenBook.isEmpty()) throw new BookNotFoundException();
        takenBookRepository.deleteById(id);
        warehouseRepository.increaseNumber(takenBook.get().getBook().getId());
    }

    @Override
    public Warehouse findWarehouseByBookId(UUID bookId) {
        return warehouseRepository.findByBookId(bookId);
    }

    @Override
    public PersonDto findPersonByEmail(String email) {
        Person person = personRepository.findByEmail(email).orElseThrow(() -> new PersonNotFoundException());
        return conversionService.convert(person, PersonDto.class);
    }
}
