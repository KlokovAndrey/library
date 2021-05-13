package com.library.service.impl;

import com.library.controller.exception.AuthorNotFoundException;
import com.library.controller.exception.PersonNotFoundException;
import com.library.domain.dto.BookDto;
import com.library.domain.dto.BookInfoDto;
import com.library.domain.dto.TakenBookDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.Book;
import com.library.domain.enums.GenreType;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.TakenBookRepository;
import com.library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final ConversionService conversionService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final TakenBookRepository takenBookRepository;
    @Override
    public BookInfoDto findBookById(UUID id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) throw new PersonNotFoundException();
        else return conversionService.convert(book.get(), BookInfoDto.class);
    }

    @Override
    public List<BookDto> findBookByName(String name) {
        return bookRepository.findAll(((root, query, criteriaBuilder) -> criteriaBuilder
                .and(criteriaBuilder
                        .like(criteriaBuilder
                                .lower(root.get("name")), '%' + name.toLowerCase() + '%')))
        )
                .stream()
                .map(book -> conversionService.convert(book, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findBookByAuthor(UUID authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isEmpty()) throw new AuthorNotFoundException();
        else return bookRepository.findByAuthors(author.get())
                .stream()
                .map(book -> conversionService.convert(book, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<BookDto> findBookByGenre(String genre, Pageable pageable) {
        return bookRepository.findByGenre(GenreType.valueOf(genre), pageable)
                .map(book -> conversionService.convert(book, BookDto.class));
    }

    @Override
    public List<TakenBookDto> findAllTakenBook(UUID id) {
        return takenBookRepository.findByPerson(id)
                .stream()
                .map(book -> conversionService.convert(book, TakenBookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TakenBookDto> isExpired(UUID personId){
        return takenBookRepository.findExpired(personId, LocalDate.now().minusMonths(1))
                .stream()
                .map(book -> conversionService.convert(book, TakenBookDto.class))
                .collect(Collectors.toList());
    }
}
