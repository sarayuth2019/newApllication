package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
