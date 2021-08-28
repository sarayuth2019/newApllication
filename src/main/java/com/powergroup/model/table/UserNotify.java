package com.powergroup.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "user_notify_entity")
public class UserNotify {
    @Id
    @Column(name = "user_notify_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notifyId;

    @Column
    private int amount;

    @Column
    private String status;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "pay_id")
    private int payId;

    @Column(name = "create_date")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date createDate = new Date();
}
