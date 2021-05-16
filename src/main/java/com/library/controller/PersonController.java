package com.library.controller;

import com.library.domain.dto.BookDto;
import com.library.domain.dto.BookInfoDto;
import com.library.domain.dto.PersonDto;
import com.library.domain.dto.TakenBookDto;
import com.library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
@RequestMapping("/persons")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PersonController {
    private final PersonService personService;

    @GetMapping("/{id}")
    public BookInfoDto findBookById(@PathVariable("id") UUID id){
        return personService.findBookById(id);
    }

    @GetMapping("find-by-name")
    public List<BookDto> findBookByName(@RequestParam("name") String name){
        return personService.findBookByName(name);
    }

    @GetMapping("find-by-author")
    public List<BookDto> findBookByAuthor(@RequestParam("authorId") UUID id){
        return personService.findBookByAuthor(id);
    }
    //SecurityContextHolder.getContext().getAuthentication()

    @GetMapping("find-by-genre")
    public Page<BookDto> findBookByGenre(@RequestParam("genre") String genre, Pageable pageable){
        return personService.findBookByGenre(genre, pageable);
    }

    @GetMapping("get-all-taken-books/{id}")
    public List<TakenBookDto> getAllTakenBooks(@PathVariable("id") UUID id, @AuthenticationPrincipal UserDetails userDetails){
        return personService.findAllTakenBook(id);
    }

    @GetMapping("/isExpired/{id}")
    public List<TakenBookDto> isExpired(@PathVariable("id") UUID id){
        return personService.isExpired(id);
    }

}
