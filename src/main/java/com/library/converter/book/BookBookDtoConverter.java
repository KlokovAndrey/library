package com.library.converter.book;

import com.library.domain.dto.AuthorDto;
import com.library.domain.dto.BookDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class BookBookDtoConverter implements Converter<Book, BookDto> {

    private final ConversionService conversionService;
    @Override
    public BookDto convert(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        Set<Author> authors = book.getAuthors();
        List<AuthorDto> authorsDto = new LinkedList<>();
        for(Author author : authors){
            authorsDto.add(conversionService.convert(author, AuthorDto.class));
        }
        bookDto.setAuthors(authorsDto);
        return bookDto;
    }
}
