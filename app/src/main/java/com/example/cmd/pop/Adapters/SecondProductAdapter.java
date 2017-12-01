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

public class SecondProductAdapter extends RecyclerView.Adapter<SecondProductAdapter.SecondProductViewHolder> {
    private List<Product> mProducts;
    private Context ctx;

    public SecondProductAdapter(List<Product> mProducts, Context ctx) {
        this.mProducts = mProducts;
        this.ctx = ctx;
    }

    @Override
    public SecondProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SecondProductAdapter.SecondProductViewHolder(LayoutInflater.from(ctx).inflate(R.layout.second_product_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(SecondProductViewHolder holder, int position) {
        holder.bind(mProducts.get(position));
    }


    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class SecondProductViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle,mPrice;

        public SecondProductViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView)itemView.findViewById(R.id.secondProductTitle);
            mPrice = (TextView)itemView.findViewById(R.id.secondProductPrice);
        }

        public void bind(Product pr) {
            mTitle.setText(pr.getTitle());
            mPrice.setText(pr.getPrice());
        }
    }
}
