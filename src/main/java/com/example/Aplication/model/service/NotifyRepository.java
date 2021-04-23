package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Notify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface NotifyRepository extends JpaRepository<Notify,Integer> {
    int deleteByUser(int user);
}
