package com.powergroup.model.service;

import com.powergroup.model.table.Image;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<Image,Integer> {
    Image findByMarketId(int marketId);
    Image findByItemId(int itemId);
}
