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
    @Column(name = "name_post")
    private String name;
    @Column(name = "surname_post")
    private String surname;
    @Column(name = "picture_user")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String picture;
    @Column
    private Long user_id;
}
