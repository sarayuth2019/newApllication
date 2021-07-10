package com.example.Aplication.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private int cartId;

    @Column
    private int status;

    @Column(name = "name_cart")
    private String nameCart;

    @Column(name = "image_cart")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String imageCart;

    @Column
    private int number;

    @Column
    private int price;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "item_id")
    private int itemId;

    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date date = new Date();
}
