package com.powergroup.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "backup_notify_entity")
public class BackupNotify {
    @Column(name = "backup_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int backupId;

    @Column
    private String name;

    @Column
    private int amount;

    @Column
    private String status;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "market_id")
    private int marketId;

    @Column(name = "item_id")
    private int payId;

    @Column(name = "create_date")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date createDate = new Date();
}
