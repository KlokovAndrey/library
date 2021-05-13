package com.library.converter.takenBook;

import com.library.domain.dto.AuthorDto;
import com.library.domain.dto.TakenBookDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.TakenBook;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TakenBookTakenBookDtoConverter implements Converter<TakenBook, TakenBookDto> {

    private final ConversionService conversionService;
    @Override
    public TakenBookDto convert(TakenBook takenBook) {
        TakenBookDto takenBookDto = new TakenBookDto();
        takenBookDto.setId(takenBook.getId());
        takenBookDto.setName(takenBook.getBook().getName());
        takenBookDto.setDateOfReceiving(takenBook.getDateOfReceiving());
        Set<Author> authors = takenBook.getBook().getAuthors();
        List<AuthorDto> authorsDto = new LinkedList<>();
        for(Author author : authors){
            authorsDto.add(conversionService.convert(author, AuthorDto.class));
        }
        takenBookDto.setAuthors(authorsDto);
        return takenBookDto;
    }
}
