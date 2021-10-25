package com.powergroup.model.service;

import com.powergroup.model.table.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByMarketId(int marketId);
}
