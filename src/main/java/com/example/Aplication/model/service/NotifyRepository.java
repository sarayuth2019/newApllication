package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Notify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface NotifyRepository extends JpaRepository<Notify,Integer> {
    List<Notify> findByUser(int user);
    int deleteByUser(int user);
}
