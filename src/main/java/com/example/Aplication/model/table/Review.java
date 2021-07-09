package com.example.Aplication.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "review_entity")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "items_id")
    private int itemsId;

    @Column(name = "user_id")
    private int userId;

    @Column
    private double rating;

    @Column
    private String content;

    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date date = new Date();
}
