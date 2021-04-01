package com.library.controller;

import com.library.dto.BookFileDto;
import com.library.service.BookFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/bookFiles")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BookFileController {
    private final BookFileService bookFileService;

    @GetMapping("/{id}")
    public BookFileDto findById(@PathVariable("id") String id){
        return bookFileService.findById(id);
    }


    @PostMapping("/{id}")
    public BookFileDto create(@PathVariable("id") String bookId, @RequestParam("file")MultipartFile file){
        return bookFileService.create(bookId, file);
    }


    @PutMapping("/{id}")
    public BookFileDto update(@PathVariable("id") String id, @RequestBody BookFileDto bookFileDto){
        return bookFileService.update(id, bookFileDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        bookFileService.delete(id);
    }

}
