package com.example.Aplication.model.table;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Data
@ToString
@Entity(name = "Items_entity")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Items_id")
    private int id;
    @Column(name = "Name_items")
    @NotNull
    private String name;
    @Column(name = "Image_items")
    @Lob
    private String Image;
    @Column
    @NotNull
    private String description;
    @Column
    @NotNull
    private int rating;
    @Column
    @NotNull
    private int count_rating;
    @Column
    @NotNull
    private int price;
    @Column
    @NotNull
    private String location;
    @Column(name = "user_id")
    @NotNull
    private int user;
    @Column
    private Date date = new Date();


}
