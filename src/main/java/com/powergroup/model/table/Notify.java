package com.powergroup.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "notify_entity")
public class Notify {
    @Id
    @Column(name = "notify_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notifyId;

    @Column
    private String name;

    @Column
    private int number;

    @Column
    private int price;

    @Column
    private String status;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "market_id")
    private int marketId;

    @Column(name = "item_id")
    private int itemId;

    @Column
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String image;

    @Column(name = "create_date")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date createDate = new Date();
}
