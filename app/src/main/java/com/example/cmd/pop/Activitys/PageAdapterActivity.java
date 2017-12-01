package com.example.cmd.pop.Activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.cmd.pop.Adapters.CustomPageAdapter;
import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 1.12.17.
 */

public class PageAdapterActivity extends AppCompatActivity {
    private ViewPager mPager;
    private ArrayList<Product> mProducts;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_adapter_activity);
        Bundle bundle = getIntent().getExtras();
        try {
            mProducts = bundle.getParcelableArrayList("productList");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        mPager = (ViewPager)findViewById(R.id.viewPager);
        mPager.setAdapter(new CustomPageAdapter(this,mProducts));


    }
}
