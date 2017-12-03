package com.example.cmd.pop.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cmd.pop.Activitys.CartActivity;
import com.example.cmd.pop.Activitys.MainActivity;
import com.example.cmd.pop.JavaClasses.CartProductList;
import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;
import com.example.cmd.pop.notifications.NotificationCountSetClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 1.12.17.
 */

public class CustomPageAdapter extends PagerAdapter {

    private TextView mTitle,mDesc,mPrice;
    private Button addToCart, cartCheckout;
    private Context context;
    private List<Product> mProducts;
    private int pos = 0;

    public CustomPageAdapter(Context context, List<Product> products) {
        this.context = context;
        this.mProducts = products;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Product product = mProducts.get(position);
        pos = position;
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.single_product_layout,container,false);
        mTitle = (TextView)layout.findViewById(R.id.singleItemTitle);
        mDesc = (TextView)layout.findViewById(R.id.singleItemDescription);
        mPrice = (TextView)layout.findViewById(R.id.singleItemPrice);
        addToCart = (Button)layout.findViewById(R.id.singleItemAddCartBtn);
        cartCheckout = (Button)layout.findViewById(R.id.singleItemCartCheckout);
        mTitle.setText(product.getTitle());
        mPrice.setText(product.getPrice());
        container.addView(layout);
        onItemClick();
        return layout;

    }

    private void onItemClick() {
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartProductList.setProductsForPager(mProducts.get(pos));
//                Intent i = new Intent(context, CartActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("product",mProducts.get(pos));
//                i.putExtras(bundle);
//                context.startActivity(i);
                MainActivity.notificationCountCart++;
                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);

            }
        });

        cartCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CartActivity.class));
            }
        });
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View) object);
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
