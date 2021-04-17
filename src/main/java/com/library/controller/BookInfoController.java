package com.library.controller;

import com.library.domain.dto.BookDto;
import com.library.domain.dto.BookInfoDto;
import com.library.service.BookInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/name")
    public List<BookInfoDto> findByName(@RequestParam("name") String name){
        return bookInfoService.findByName(name);
    }

    @GetMapping("/author/{authorId}")
    public List<BookInfoDto> findByAuthor(@PathVariable("authorId") String id){
        return bookInfoService.findByAuthor(id);
    }

    @PostMapping
    public BookInfoDto create(@RequestBody BookDto bookDto, @RequestParam("file") MultipartFile file){
        return bookInfoService.create(bookDto, file);
    }


    @PutMapping("/{id}")
    public BookInfoDto update(@PathVariable("id") String id, @RequestBody BookDto bookDto){
        return bookInfoService.update(id, bookDto);
    }

    @PatchMapping("/file/{bookId}")
    public BookInfoDto updateFile(@PathVariable("bookId") String id, @RequestBody MultipartFile file){
        return bookInfoService.updateFile(id, file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        bookInfoService.delete(id);
    }
}
