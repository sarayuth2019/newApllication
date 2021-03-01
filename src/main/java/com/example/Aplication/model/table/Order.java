package com.example.Aplication.model.table;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "order_entity")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;
    @Column(name = "name_order")
    private String name;
    @Column(name = "Image_order")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String Image;
    @Column
    private int number;
    @Column
    private int price;
    @Column(name = "customer_id")
    private int customer;
    @Column(name = "user_id")
    private int user;
    @Column
    private Date date = new Date();

}
