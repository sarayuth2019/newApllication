package com.example.Aplication.model.table;

import com.sun.istack.NotNull;
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
    @NotNull
    private String name;
    @Column(name = "Image_order")
    @NotNull
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String Image;
    @Column
    @NotNull
    private int price;
    @Column
    private int customer_id;
    @Column
    private int seller_id;
    @Column
    private Date dete = new Date();
}
