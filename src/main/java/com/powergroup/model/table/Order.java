package com.powergroup.model.table;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    private int orderId;

    @Column
    private String status;

    @Column(name = "name_order")
    private String nameOrder;

    @Column
    private int number;

    @Column
    private int price;

    @Column(name = "market_id")
    private int marketId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "item_id")
    private int item;

    @Column(name = "create_date")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date createDate = new Date();

}
