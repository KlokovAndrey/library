package com.library.repository;

import com.library.domain.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarehouseRepository extends JpaRepository<Warehouse, UUID> {
    Warehouse save(Warehouse warehouse);
}
