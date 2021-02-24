package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion,Integer> {
}
