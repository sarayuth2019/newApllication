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
    private String image;
    @Column
    private int marketId;
    @Column
    private int ItemId;

    public int getMarketId() {
        return marketId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
