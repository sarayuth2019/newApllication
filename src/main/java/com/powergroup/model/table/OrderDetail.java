package com.powergroup.model.table;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailId;

    @Column
    private int orderId;

    @Column
    private String nameItem;

    @Column
    private String color;

    @Column
    private String size;

    @Column
    private int number;

    @Column
    private int price;

}
