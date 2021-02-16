package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PostRepository extends JpaRepository<Post,Long> {
}
