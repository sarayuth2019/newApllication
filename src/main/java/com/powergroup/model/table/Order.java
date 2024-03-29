package com.powergroup.model.table;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

//    @Column
//    private ArrayList detail;

    @Column
    private int priceSell;

    @Column(name = "market_id")
    private int marketId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "date_begin")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "dd/MM/yyyy")
    private Date dateBegin;

    @Column(name = "date_final")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "dd/MM/yyyy")
    private Date dateFinal;

    @Column(name = "deal_begin")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "dd/MM/yyyy")
    private Date dealBegin;

    @Column(name = "deal_final")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "dd/MM/yyyy")
    private Date dealFinal;

    @Column(name = "create_date")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/MMM/yyyy")
    private Date createDate = new Date();

}
