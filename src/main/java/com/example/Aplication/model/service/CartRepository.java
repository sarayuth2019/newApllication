
package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Optional<Cart>findById(int id);
    List<Cart> findByName(String name);
    List<Cart>findByUser(int user);
}
