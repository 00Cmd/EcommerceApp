package com.example.cmd.pop.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.cmd.pop.Activitys.MainActivity;
import com.example.cmd.pop.Adapters.CartAdapter;
import com.example.cmd.pop.JavaClasses.CartProductList;
import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 2.12.17.
 */

public class CartFragment extends Fragment {
    private List<Product> mProducts;
    private RecyclerView mView;


    public CartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cart_fragment_layout,container,false);

            if (mProducts == null) {
                mProducts = new ArrayList<>();
            mProducts = CartProductList.getProductsForCart();
        }
        setCartLayout(v);

        mView = (RecyclerView)v.findViewById(R.id.recyclerview);

        mView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false));

        CartAdapter adapter = new CartAdapter(mProducts, getActivity());
        mView.setAdapter(adapter);

        return v;
    }

    protected void setCartLayout(View v){
        LinearLayout layoutCartItems = (LinearLayout)v.findViewById(R.id.layout_items);
        LinearLayout layoutCartPayments = (LinearLayout)v.findViewById(R.id.layout_payment);
        LinearLayout layoutCartNoItems = (LinearLayout)v.findViewById(R.id.layout_cart_empty);

        if(MainActivity.notificationCountCart >0 || mProducts.size() > 0){
            layoutCartNoItems.setVisibility(View.GONE);
            layoutCartItems.setVisibility(View.VISIBLE);
            layoutCartPayments.setVisibility(View.VISIBLE);
        }else {
            layoutCartNoItems.setVisibility(View.VISIBLE);
            layoutCartItems.setVisibility(View.GONE);
            layoutCartPayments.setVisibility(View.GONE);
        }
    }
}
