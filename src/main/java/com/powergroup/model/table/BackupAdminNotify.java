package com.powergroup.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Data
@ToString
@Entity(name = "admin_backup_notify_entity")
public class BackupAdminNotify {
        @Id
        @Column(name = "backup_admin_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int backupId;

        @Column
        private String status;

        @Column(name = "pay_id")
        private int payId;

        @Column(name = "create_date")
        @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/MMM/yyyy")
        private Date createDate = new Date();
    }

