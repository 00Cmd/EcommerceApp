package com.example.cmd.pop.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;

import java.util.List;

/**
 * Created by cmd on 17.11.17.
 */

public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.MainViewHolder> {
    private List<Product> mProducts;
    private Context ctx;

    public MainViewAdapter(List<Product> mProducts, Context ctx) {
        this.mProducts = mProducts;
        this.ctx = ctx;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewAdapter.MainViewHolder(LayoutInflater.from(ctx).inflate(R.layout.product_list_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.bind(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle,mPrice;

        public MainViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView)itemView.findViewById(R.id.productTitle);
            mPrice = (TextView)itemView.findViewById(R.id.productPrice);
        }

        public void bind(Product pr) {
            mTitle.setText(pr.getTitle());
            mPrice.setText(pr.getPrice());
        }
    }
}
