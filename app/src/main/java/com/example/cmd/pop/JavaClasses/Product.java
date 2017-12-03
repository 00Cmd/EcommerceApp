package com.example.cmd.pop.JavaClasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by cmd on 17.11.17.
 */

public class Product {
    private String title,price,id;
    private UUID mId;
    private int intId = 0;

    public Product(String title, String price) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.price = price;
    }

    public Product() {
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

    public int getId() {

        return intId;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }

//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(getId());
//        dest.writeString(getTitle());
//        dest.writeString(getPrice());
//    }
//
//    public Product(Parcel in) {
//        int id = getId();
//         id = in.readInt();
//         title = in.readString();
//         price = in.readString();
//    }
//
//    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
//        public Product createFromParcel(Parcel in) {
//            return new Product(in);
//        }
//
//        public Product[] newArray(int size) {
//            return new Product[size];
//        }
//    };
}
