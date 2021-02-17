package com.example.Aplication.model.table;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Data
@Entity(name = "post_entity")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    @Column
    private String textPost;
    @Column
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String picturePost;
    @Column
    private Date datePost = new Date();
    @Column
    private Long user_id;
}
