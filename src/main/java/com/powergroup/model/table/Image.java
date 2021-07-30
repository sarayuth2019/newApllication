package com.powergroup.model.table;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "image_entity")
@Data
@ToString
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @Basic(fetch = FetchType.LAZY)
    private String imageName;
    @Column
    private int marketId;
    @Column
    private int itemId;


}
