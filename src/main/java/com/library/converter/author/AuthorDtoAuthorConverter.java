package com.library.converter.author;

import com.library.domain.dto.AuthorDto;
import com.library.domain.entity.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class AuthorDtoAuthorConverter implements Converter<AuthorDto, Author> {
    @Override
    public Author convert(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setBooks(new HashSet<>());
        return author;
    }
}
