package com.example.cmd.pop;

/**
 * Created by cmd on 17.11.17.
 */

public class Product {
    private String title,price;

    public Product(String title, String price) {
        this.title = title;
        this.price = price;
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
