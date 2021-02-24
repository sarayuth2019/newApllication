package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
