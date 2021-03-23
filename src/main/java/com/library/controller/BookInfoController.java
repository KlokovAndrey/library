package com.library.controller;

import com.library.dto.Book;
import com.library.dto.BookInfoDto;
import com.library.service.BookInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booksInfo")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BookInfoController {
    private final BookInfoService bookInfoService;

    @GetMapping("/{id}")
    public BookInfoDto findById(@PathVariable("id") String id){
        return bookInfoService.findById(id);
    }

    @GetMapping
    public List<BookInfoDto> findByName(@RequestParam("name") String name){
        return bookInfoService.findByName(name);
    }

    @GetMapping
    public List<BookInfoDto> findByAuthor(@RequestParam("author") String author){
        return bookInfoService.findByAuthor(author);
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        return bookInfoService.create(book);
    }


    @PutMapping("/{id}")
    public BookInfoDto update(@PathVariable("id") String id, @RequestBody BookInfoDto bookInfoDto){
        return bookInfoService.update(id, bookInfoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        bookInfoService.delete(id);
    }
}
