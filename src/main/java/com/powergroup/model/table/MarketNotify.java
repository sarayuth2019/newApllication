package com.powergroup.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Data
@ToString
@Entity(name = "market_notify_entity")
public class MarketNotify {
    @Column(name = "notify_market_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notifyId;

    @Column
    private int count;

    @Column
    private int countRequest;

    @Column
    private String status;

    @Column(name = "market_id")
    private int marketId;

    @Column(name = "pay_id")
    private int payId;

    @Column(name = "create_date")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date createDate = new Date();
}

