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
    private String imageName;
    @Column
    private int marketId;
    @Column
    private int itemId;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getMarketId() {
        return marketId;
    }
}
