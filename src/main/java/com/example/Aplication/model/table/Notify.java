package com.example.Aplication.model.table;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int number;
    @Column
    private int price;
    @Column
    private String status;
    @Column(name = "user_id")
    private int user;
    @Column(name = "customer_id")
    private int customer;
    @Column(name = "item_id")
    private int item;
    @Column
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String Image;
    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date date = new Date();
}
