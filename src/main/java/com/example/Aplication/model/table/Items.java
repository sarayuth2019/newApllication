package com.example.Aplication.model.table;
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
    @Column(name = "Items_id")
    private int id;
    @Column(name = "Name_items")
    private String name;
    @Column(name = "Image_items")
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String Image;
    @Column(name = "group_items")
    private int group;
    @Column
    private int price;
    @Column
    private int price_sell;
    @Column
    private int count;
    @Column
    private int count_request;
    @Column(name = "user_id")
    private int user;
    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "dd-MMM-yyyy")
    private Date date_begin;
    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "dd-MMM-yyyy")
    private Date date_final;
    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "dd-MMM-yyyy")
    private Date deal_begin;
    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "dd-MMM-yyyy")
    private Date deal_final;
    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date date = new Date();
}
