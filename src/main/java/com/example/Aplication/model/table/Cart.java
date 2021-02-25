package com.example.Aplication.model.table;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@NotNull
@Data
@ToString
@Entity(name = "cart_entity")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;
    @Column
    private int status;
    @Column(name = "name_cart")
    private String name;
    @Column(name = "Image_cart")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String Image;
    @Column
    private int price;
    @Column
    private int customer_id;
    @Column(name = "user_id")
    private int user;
    @Column
    private Date date = new Date();
}
