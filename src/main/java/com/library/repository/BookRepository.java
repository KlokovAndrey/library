package com.library.repository;

import com.library.domain.entity.Author;
import com.library.domain.entity.Book;
import com.library.domain.enums.GenreType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID>, JpaSpecificationExecutor<Book> {
    Book save(Book book);
    Optional<Book> findById(UUID id);
    List<Book> findByNameContaining(String name);
    //List<Book> findByGenre(GenreType genre);
    Page<Book> findByGenre(GenreType genre, Pageable pageable);
    List<Book> findByAuthors(Author author);
}
