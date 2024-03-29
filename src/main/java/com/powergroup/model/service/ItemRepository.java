package com.powergroup.model.service;

import com.powergroup.model.table.Items;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public interface ItemRepository extends JpaRepository<Items, Integer> {
    //Optional<Items> findById(int id);
    List<Items> findByNameItems(String nameItems);
    List<Items> findByMarketId(int marketId);
    List<Items> findByGroupItems(int groupItems);
    List<Items> findByDealFinal(Date dealFinal);
}
