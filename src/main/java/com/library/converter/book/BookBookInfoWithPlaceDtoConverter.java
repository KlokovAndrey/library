package com.library.converter.book;

import com.library.domain.dto.AuthorDto;
import com.library.domain.dto.BookInfoDto;
import com.library.domain.dto.BookInfoWithPlaceDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.Book;
import com.library.domain.entity.Warehouse;
import com.library.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
@Component
@RequiredArgsConstructor
public class BookBookInfoWithPlaceDtoConverter implements Converter<Book, BookInfoWithPlaceDto> {
    private final ConversionService conversionService;
    private final LibrarianService librarianService;
    @Override
    public BookInfoWithPlaceDto convert(Book book) {
        BookInfoWithPlaceDto bookInfoWithPlaceDto = new BookInfoWithPlaceDto();
        bookInfoWithPlaceDto.setId(book.getId());
        bookInfoWithPlaceDto.setName(book.getName());
        Set<Author> authors = book.getAuthors();
        List<AuthorDto> authorsDto = new LinkedList<>();
        for(Author author : authors){
            authorsDto.add(conversionService.convert(author, AuthorDto.class));
        }
        bookInfoWithPlaceDto.setAuthors(authorsDto);
        bookInfoWithPlaceDto.setGenre(book.getGenre());
        bookInfoWithPlaceDto.setYearOfPublishing(book.getYearOfPublishing());
        Warehouse warehouse = librarianService.findWarehouseByBookId(book.getId());
        bookInfoWithPlaceDto.setRow(warehouse.getRow());
        bookInfoWithPlaceDto.setShelf(warehouse.getShelf());
        return bookInfoWithPlaceDto;
    }
}
