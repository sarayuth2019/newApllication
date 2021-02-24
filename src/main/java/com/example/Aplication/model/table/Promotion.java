package com.example.Aplication.model.table;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@Entity(name = "Promotion_entity")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Promotion_text")
    @NotNull
    private String text;
    @Column(name = "Image_promotion")
    @NotNull
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String Image;
    @Column
    @NotNull
    private String promotion_time;
}
