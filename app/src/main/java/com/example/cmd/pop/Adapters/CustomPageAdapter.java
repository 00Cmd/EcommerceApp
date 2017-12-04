package com.example.cmd.pop.Adapters;

import android.content.Context;
import android.content.Intent;
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

import java.util.List;

/**
 * Created by cmd on 1.12.17.
 */

public class CustomPageAdapter extends PagerAdapter {

    private Button addToCart, cartCheckout;
    private Context context;
    private List<Product> mProducts;
    private Product product;

    public CustomPageAdapter(Context context, List<Product> products) {
        this.context = context;
        this.mProducts = products;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        product = mProducts.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v =  inflater.inflate(R.layout.single_product_layout,container,false);
        TextView mTitle = (TextView) v.findViewById(R.id.singleItemTitle);
        TextView mDesc = (TextView) v.findViewById(R.id.singleItemDescription);
        TextView mPrice = (TextView) v.findViewById(R.id.singleItemPrice);
        addToCart = (Button)v.findViewById(R.id.singleItemAddCartBtn);
        cartCheckout = (Button)v.findViewById(R.id.singleItemCartCheckout);
        mTitle.setText(product.getTitle());
        mPrice.setText(product.getPrice());
        container.addView(v);
        onItemClick(product);
        return v;
    }


    private void onItemClick(final Product pr) {
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartProductList.addProductToCart(pr);
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
