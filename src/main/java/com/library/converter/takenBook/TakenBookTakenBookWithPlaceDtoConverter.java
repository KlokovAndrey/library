package com.library.converter.takenBook;

import com.library.domain.dto.AuthorDto;
import com.library.domain.dto.TakenBookDto;
import com.library.domain.dto.TakenBookWithPlaceDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.TakenBook;
import com.library.domain.entity.Warehouse;
import com.library.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TakenBookTakenBookWithPlaceDtoConverter implements Converter<TakenBook, TakenBookWithPlaceDto> {
    private final ConversionService conversionService;
    private final WarehouseRepository warehouseRepository;

    @Override
    public TakenBookWithPlaceDto convert(TakenBook takenBook) {
        TakenBookWithPlaceDto takenBookWithPlaceDto = new TakenBookWithPlaceDto();
        takenBookWithPlaceDto.setId(takenBook.getId());
        takenBookWithPlaceDto.setName(takenBook.getBook().getName());
        takenBookWithPlaceDto.setDateOfReceiving(takenBook.getDateOfReceiving());
        Set<Author> authors = takenBook.getBook().getAuthors();
        List<AuthorDto> authorsDto = new LinkedList<>();
        for(Author author : authors){
            authorsDto.add(conversionService.convert(author, AuthorDto.class));
        }
        takenBookWithPlaceDto.setAuthors(authorsDto);
        Warehouse warehouse = warehouseRepository.findByBookId(takenBook.getBook().getId());
        takenBookWithPlaceDto.setRow(warehouse.getRow());
        takenBookWithPlaceDto.setShelf(warehouse.getShelf());
        return takenBookWithPlaceDto;
    }
}
