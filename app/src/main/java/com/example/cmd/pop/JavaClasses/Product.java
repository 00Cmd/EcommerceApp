package com.example.cmd.pop.JavaClasses;

import java.util.UUID;

/**
 * Created by cmd on 17.11.17.
 */

public class Product {
    private String title,price,id;
    private UUID mId;

    public Product(String title, String price) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.price = price;
    }

    public Product() {
    }

    public UUID getmId() {
        return mId;
    }

    public String getStringId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
