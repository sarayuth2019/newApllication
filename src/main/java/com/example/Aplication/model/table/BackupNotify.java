package com.example.Aplication.model.table;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Data
@ToString
@Entity(name = "backup_notify_entity")
public class BackupNotify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int number;
    @Column
    private int price;
    @Column (name = "customer_id")
    private int customer;
    @Column(name = "user_id")
    private int user;
    @Column(name = "item_id")
    private int item;
    @Column
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String Image;
    @Column
    private Date date = new Date();
}
