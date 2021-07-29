package com.powergroup.model.service;

import com.powergroup.model.table.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ImageRepository extends JpaRepository<Image,Integer> {
//    Image findByMarketId(int marketId);
    Optional<Image> findByItemId(int itemId);
}
