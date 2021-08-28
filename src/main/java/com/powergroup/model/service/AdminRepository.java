package com.powergroup.model.service;

import com.powergroup.model.table.AdminNotify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AdminRepository extends JpaRepository<AdminNotify,Integer> {
}
