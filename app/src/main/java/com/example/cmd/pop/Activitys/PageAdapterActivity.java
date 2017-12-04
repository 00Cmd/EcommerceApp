package com.example.cmd.pop.Activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.cmd.pop.Adapters.CustomPageAdapter;
import com.example.cmd.pop.JavaClasses.CartProductList;
import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 1.12.17.
 */

public class PageAdapterActivity extends AppCompatActivity {
    private ViewPager mPager;
    private List<Product> mProducts;
    private int position;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_adapter_activity);
        ArrayList<Product> productList = new ArrayList<>();
        Bundle bundle = new Bundle();
        if(getIntent().getExtras() != null) {
            productList = getIntent().getExtras().getParcelableArrayList("products");
            position = getIntent().getIntExtra("position",0);
        }
        if(productList != null) {
            mProducts = new ArrayList<>();
            mProducts.addAll(productList);
        } else {
            Toast.makeText(this, "ProductList empty...", Toast.LENGTH_SHORT).show();
        }
        mPager = (ViewPager)findViewById(R.id.viewPager);
        mPager.setAdapter(new CustomPageAdapter(this,mProducts));
        mPager.setCurrentItem(position);


    }
}
