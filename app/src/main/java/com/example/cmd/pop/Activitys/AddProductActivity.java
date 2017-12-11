package com.example.cmd.pop.Activitys;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.cmd.pop.Fragments.AddProductFragment;
import com.example.cmd.pop.R;

/**
 * Created by cmd on 10.12.17.
 */

public class AddProductActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product_activity);
        FragmentManager fm = getSupportFragmentManager();
        Fragment framgnet = new AddProductFragment();
        fm.beginTransaction().add(R.id.addProductContainer,framgnet).commit();
    }
}
