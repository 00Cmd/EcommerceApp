package com.example.cmd.pop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 17.11.17.
 */

public class MockData {
    public static List<Product> getProductData() {
        Product pr = new Product("Product#1","100.00$");
        Product pr1 = new Product("Product2","100.00$");
        Product pr2 = new Product("Product3","100.00$");
        Product pr3 = new Product("Product4","100.00$");
        List<Product> mProducts = new ArrayList<>();
        mProducts.add(pr);
        mProducts.add(pr1);
        mProducts.add(pr2);
        mProducts.add(pr3);
        return mProducts;
    }
}
