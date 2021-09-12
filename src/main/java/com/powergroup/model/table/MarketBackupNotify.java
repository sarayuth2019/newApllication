package com.powergroup.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "market_backup_notify_entity")
@Data
@ToString
public class MarketBackupNotify {
    @Column(name = "backup_market_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int backupId;

    @Column
    private int amount;

    @Column
    private String status;

    @Column(name = "market_id")
    private int marketId;

    @Column(name = "pay_id")
    private int payId;

    @Column(name = "create_date")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/MMM/yyyy")
    private Date createDate = new Date();
}
