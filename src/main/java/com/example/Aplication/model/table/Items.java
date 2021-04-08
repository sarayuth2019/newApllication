package com.example.Aplication.model.table;
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
    private String name;
    @Column(name = "Image_items")
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String Image;
    @Column(name = "group_items")
    private int group;
    @Column
    private String description;
    @Column
    private int price;
    @Column
    private String location;
    @Column(name = "user_id")
    private int user;
    @Column
    private int discount;
    @Column
    private int count_promotion;
    @Column(name = "status_promotion")
    private int status;
    @Column
    private Date date = new Date();
}
