package com.powergroup.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Data
@ToString
@Entity(name = "admin_notify_entity")
public class AdminNotify {
    @Id
    @Column(name = "notifyAdmin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notifyId;

    @Column
    private String status;

    @Column(name = "item_id")
    private int payId;

    @Column(name = "create_date")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date createDate = new Date();
}
