package com.example.cmd.pop.Activitys;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cmd.pop.Adapters.CartAdapter;
import com.example.cmd.pop.Fragments.CartFragment;
import com.example.cmd.pop.JavaClasses.CartProductList;
import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 2.12.17.
 */

public class CartActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity_layout);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new CartFragment();
        fm.beginTransaction().add(R.id.cartContainer,fragment).commit();


    }
}
