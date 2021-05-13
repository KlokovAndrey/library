package com.library.converter.book;

import com.library.domain.dto.BookInfoDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookInfoDtoBookConverter implements Converter<BookInfoDto, Book> {
    private final ConversionService conversionService;
    @Override
    public Book convert(BookInfoDto bookInfoDto) {
        Book book = new Book();
        book.setName(bookInfoDto.getName());
        book.setYearOfPublishing(bookInfoDto.getYearOfPublishing());
        book.setGenre(bookInfoDto.getGenre());
        book.setAuthors(
                bookInfoDto.getAuthors()
                        .stream()
                        .map(author -> conversionService.convert(author, Author.class))
                        .collect(Collectors.toSet()));
        return book;
    }
}
