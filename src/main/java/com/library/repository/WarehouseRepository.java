package com.library.repository;

import com.library.domain.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public interface WarehouseRepository extends JpaRepository<Warehouse, UUID> {
    Warehouse save(Warehouse warehouse);
    @Modifying
    @Query("UPDATE Warehouse warehouse SET warehouse.number = warehouse.number - 1 WHERE warehouse.book.id=:bookId")
    void decreaseNumber(UUID bookId);
    @Query("SELECT warehouse.number FROM Warehouse warehouse WHERE warehouse.book.id=:bookId")
    int getNumber(UUID bookId);
    @Modifying
    @Query("UPDATE Warehouse warehouse SET warehouse.number = warehouse.number + 1 WHERE warehouse.book.id=:bookId")
    void increaseNumber(UUID bookId);
    @Query("SELECT warehouse FROM Warehouse warehouse WHERE warehouse.book.id=:id")
    Warehouse findByBookId(UUID id);

}
