package com.example.Aplication.model.table;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "post_entity")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name_post;
    @Column
    private String surname_post;
    @Column
    private String textpost;
    @Column
    private String picturepost;
    @Column
    private Date datePost = new Date();



}
