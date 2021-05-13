package com.library.converter.author;

import com.library.domain.dto.AuthorDto;
import com.library.domain.entity.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorAuthorDtoConverter implements Converter<Author, AuthorDto> {
    @Override
    public AuthorDto convert(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        return authorDto;
    }
}
