package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;
@Transactional
public interface PromotionRepository extends JpaRepository<Promotion,Integer> {
    Optional<Promotion>findById(int id);
}
