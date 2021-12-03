package com.powergroup.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "Items_entity")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "items_id")
    private int itemId;

    @Column(name = "name_items")
    private String nameItems;


    @Column(name = "group_items")
    private int groupItems;

    @Column
    private int price;

    @Column(name = "price_sell")
    private int priceSell;

    @Column
    private int count;

    @Column
    private String[] size;

    @Column
    private String[] colors;

    @Column(name = "count_request")
    private int countRequest;

    @Column(name = "market_id")
    private int marketId;

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
