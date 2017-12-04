package com.example.cmd.pop.JavaClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 3.12.17.
 */

public class CartProductList {
    private static List<Product> sProducts = new ArrayList<>();
    public CartProductList() {
    }

    public static void addProductToCart(Product pr) {
        sProducts.add(pr);
    }

    public static List<Product> getProductsForCart() {
        return sProducts;
    }






}
