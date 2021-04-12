package com.library.controller;

import com.library.domain.dto.PersonDto;
import com.library.domain.dto.TakenBookDto;
import com.library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PersonController {
    private final PersonService personService;

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable("id") String id){
        return personService.findById(id);
    }

    @GetMapping
    public List<PersonDto> findByName(@RequestParam("name") String name){
        return personService.findByName(name);
    }


    @PostMapping
    public PersonDto create(@RequestBody PersonDto personDto){
        return personService.create(personDto);
    }


    @PutMapping("/{id}")
    public PersonDto update(@PathVariable("id") String id, @RequestBody PersonDto personDto){
        return personService.update(id, personDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        personService.delete(id);
    }

    @GetMapping("/addBook/{personId}/{bookId}")
    public TakenBookDto addBook(@PathVariable("personId") String personId, @PathVariable("bookId") String bookId){
        return personService.addBook(personId, bookId);
    }

    @GetMapping("/removeBook/{personId}/{bookId}")
    public void removeBook(@PathVariable("personId") String personId, @PathVariable("bookId") String bookId){
        personService.removeBook(personId, bookId);
    }

    @GetMapping("/isExpired/{id}")
    public List<TakenBookDto> isExpired(@PathVariable("id") String id){
        return personService.isExpired(id);
    }

}
