package com.library.repository;

import com.library.domain.entity.TakenBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TakenBookRepository extends JpaRepository<TakenBook, UUID> {
    TakenBook save(TakenBook takenBook);
    @Query("select takenBook from TakenBook takenBook where takenBook.person.id=:id")
    List<TakenBook> findByPerson(UUID id);
    @Query("select takenBook from TakenBook takenBook where takenBook.person.id=:id AND takenBook.dateOfReceiving<:date")
    List<TakenBook> findExpired(UUID id, LocalDate date);
    void deleteById(UUID id);
}
