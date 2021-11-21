package com.powergroup.model.service;

import com.powergroup.model.table.ImagePay;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ImagePayRepository extends JpaRepository<ImagePay,Integer> {
  List<ImagePay> findByPayId(int payId);
}
