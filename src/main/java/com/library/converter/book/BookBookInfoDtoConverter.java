package com.library.converter.book;

import com.library.domain.dto.AuthorDto;
import com.library.domain.dto.BookInfoDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class BookBookInfoDtoConverter implements Converter<Book, BookInfoDto> {

    private final ConversionService conversionService;
    @Override
    public BookInfoDto convert(Book book) {
        BookInfoDto bookInfoDto = new BookInfoDto();
        bookInfoDto.setId(book.getId());
        bookInfoDto.setName(book.getName());
        Set<Author> authors = book.getAuthors();
        List<AuthorDto> authorsDto = new LinkedList<>();
        for(Author author : authors){
            authorsDto.add(conversionService.convert(author, AuthorDto.class));
        }
        bookInfoDto.setAuthors(authorsDto);
        bookInfoDto.setGenre(book.getGenre());
        bookInfoDto.setYearOfPublishing(book.getYearOfPublishing());
        return bookInfoDto;
    }
}
