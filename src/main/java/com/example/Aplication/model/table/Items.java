package com.example.Aplication.model.table;

import com.sun.istack.NotNull;
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
    @NotNull
    private String name;
    @Column(name = "Image_items")
    @NotNull
    @Lob@Basic(fetch = FetchType.LAZY)
    private String Image;
    @Column
    @NotNull
    private int price;
    @Column
    @NotNull
    private int user_id;
    @Column
    private Date date = new Date();
}
