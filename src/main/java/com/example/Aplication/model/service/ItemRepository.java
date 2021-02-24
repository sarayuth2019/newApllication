package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Items,Integer> {
    Optional<Items> findById(int id);
}
