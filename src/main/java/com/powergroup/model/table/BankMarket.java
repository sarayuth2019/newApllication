package com.powergroup.model.table;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "bank_market")
public class BankMarket {
    @Column(name = "bank_market_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bankMarketId;

    @Column
    private int marketId;

    @Column
    private String bankAccountName;

    @Column
    private String nameBank;

    @Column
    private int bankNumber;

    @Column
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/MMM/yyyy")
    private Date date = new Date();
}
