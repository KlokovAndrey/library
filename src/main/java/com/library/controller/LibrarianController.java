package com.library.controller;

import com.library.domain.dto.BookInfoDto;
import com.library.domain.dto.PersonDto;
import com.library.domain.dto.TakenBookDto;
import com.library.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/librarian")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LibrarianController {

    private final LibrarianService librarianService;

    @PostMapping("/createPerson")
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        return librarianService.createPerson(personDto);
    }

    @PostMapping("/createBook")
    public BookInfoDto createBook(@RequestBody BookInfoDto bookInfoDto) {
        return librarianService.createBook(bookInfoDto);
    }

    @GetMapping("/addBook")
    public TakenBookDto addBook(@RequestParam("person_id") UUID personId, @RequestParam("book_id") UUID bookId) {
        return librarianService.addBook(personId, bookId);
    }

    @GetMapping("/removeBook/{id}")
    public void removeBook(@PathVariable("id") UUID id) {
        librarianService.removeBook(id);
    }
}
