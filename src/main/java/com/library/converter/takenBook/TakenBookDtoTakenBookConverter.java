package com.library.converter.takenBook;

import com.library.domain.dto.TakenBookDto;
import com.library.domain.entity.TakenBook;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TakenBookDtoTakenBookConverter implements Converter<TakenBookDto, TakenBook> {
    @Override
    public TakenBook convert(TakenBookDto takenBookDto) {
        return new TakenBook();
    }
}
