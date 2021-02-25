package com.example.Aplication.model.table;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "cart_entity")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;
    @Column
    @NotNull
    private int status;
    @Column(name = "name_cart")
    @NotNull
    private String name;
    @Column(name = "Image_cart")
    @NotNull
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String Image;
    @Column
    @NotNull
    private int price;
    @Column
    private int customer_id;
    @Column(name = "user_id")
    private int user;
    @Column
    private Date date = new Date();
}
