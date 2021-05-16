package com.library.validator.mvc;

import com.library.domain.dto.BookInfoDto;
import com.library.domain.enums.GenreType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.Year;

@Component
public class BookInfoDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(BookInfoDto.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        BookInfoDto bookInfoDto = (BookInfoDto) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "genre", "genre.empty");
        if(bookInfoDto.getYearOfPublishing() > Year.now().getValue()){
            errors.rejectValue("yearOfPublishing", "yearOfPublishing.wrong");
        }
    }
}
