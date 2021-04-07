package com.example.Aplication.model.table;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "Review__entity")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "Items_id")
    private int items;
    @Column(name = "user_id")
    private int user;
    @Column
    private int rating;
    @Column
    private String content;
    @Column
    private Date date = new Date();
}
