package com.powergroup.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@ToString
@Entity(name = "pay_entity")
public class PayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pay_id")
    private int payId;

    @Column
    private String status;

    @Column
    private int userId;

    @Column
    private int orderId;

    @Column
    private int marketId;

    @Column
    private String detail;

    @Column
    private int amount;

    @Column
    //เลขท้ายบัญชี
    private int lastNumber;

    @Column
    //ธนาคารที่โอนเงิน
    private String bankTransfer;

    @Column
    //ธนาคารรับเงิน
    private String bankReceive;

    @Column
    @Temporal(TemporalType.DATE)
    //เดือน/วัน/ปี
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "dd/MM/yyyy")
    private Date date;

    @Column
    //ชั่วโมง:นาที:วืนาที
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "HH.mm.ss")
    private Time time;

    @Column
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/MMM/yyyy")
    private Date dataTransfer = new Date();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }
}
