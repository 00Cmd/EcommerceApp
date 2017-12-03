package com.example.cmd.pop.JavaClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 3.12.17.
 */

public class CartProductList {
    private static List<Product> mProducts = new ArrayList<>();
    private static List<Product> mPagerProducts = new ArrayList<>();

    public CartProductList() {
    }

    public static void setProductsForCart(Product pr) {
        mProducts.add(pr);
    }

    public static List<Product> getProductsForCart() {
        return mProducts;
    }

    public static void setProductsForPager(Product pr) {
        mPagerProducts.add(pr);
    }
    public static void setProductsForPager(List<Product> products) {
        mPagerProducts.addAll(products);
    }


    public static List<Product> getProductsForPager() {
        return mPagerProducts;
    }




}
