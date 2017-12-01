package com.example.cmd.pop.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 1.12.17.
 */

public class CustomPageAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Product> mProducts;

    public CustomPageAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.mProducts = products;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Product product = mProducts.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.single_product_layout,container,false);
        container.addView(layout);
        return layout;

    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
