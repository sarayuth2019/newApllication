package com.powergroup.model.table;

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
    private String status;

    @Column(name = "name_cart")
    private String nameCart;

    @Column
    private int number;

    @Column
    private int price;

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
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date createDate = new Date();
}
