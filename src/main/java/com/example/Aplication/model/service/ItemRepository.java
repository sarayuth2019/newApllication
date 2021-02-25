package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Items;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
public interface ItemRepository extends JpaRepository<Items,Integer> {
    Optional<Items> findById(int id);
    List<Items> findByName(String name);
    List<Items>findByUser(int user);
}
