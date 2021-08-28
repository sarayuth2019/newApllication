package com.powergroup.model.service;

import com.powergroup.model.table.AdminNotify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminNotify,Integer> {
}
