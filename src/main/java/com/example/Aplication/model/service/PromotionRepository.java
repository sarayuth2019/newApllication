package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion,Integer> {
    Optional<Promotion>findById(int id);
}
