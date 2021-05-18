package com.library.controller;

import com.library.domain.dto.*;
import com.library.service.LibrarianService;
import com.library.validator.mvc.BookInfoDtoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/librarian")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LibrarianController {

    private final LibrarianService librarianService;
    private final BookInfoDtoValidator bookInfoDtoValidator;
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(bookInfoDtoValidator);
    }

    @PostMapping("/createPerson")
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        return librarianService.createPerson(personDto);
    }

    @GetMapping("/find-person-by-email")
    public PersonDto findPersonByEmail(@RequestParam String email){
        return librarianService.findPersonByEmail(email);
    }

    @PostMapping("/createBook")
    public BookInfoWithPlaceDto createBook(@Valid @RequestBody BookInfoDto bookInfoDto) {
        return librarianService.createBook(bookInfoDto);
    }

    @GetMapping("/addBook")
    public TakenBookWithPlaceDto addBook(@RequestParam("person_id") UUID personId, @RequestParam("book_id") UUID bookId) {
        return librarianService.addBook(personId, bookId);
    }

    @GetMapping("/removeBook/{id}")
    public void removeBook(@PathVariable("id") UUID id) {
        librarianService.removeBook(id);
    }
}
