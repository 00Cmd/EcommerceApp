package com.example.cmd.pop.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;

import java.util.List;

/**
 * Created by cmd on 2.12.17.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
    private List<Product> mProducts;
    private Context context;

    public CartAdapter(List<Product> mProducts, Context context) {
        this.mProducts = mProducts;
        this.context = context;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CartAdapter.CartViewHolder(LayoutInflater.from(context).inflate(
                R.layout.cart_view,parent,false));
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        holder.bind(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle,mPrice,mAmount;
        private Button mAdd,mRemove;
        private int amount = 1;

        CartViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.cartItemTitle);
            mPrice = (TextView) itemView.findViewById(R.id.cartItemPrice);
            mAmount = (TextView) itemView.findViewById(R.id.cartViewQuantity);
            mAdd = (Button)itemView.findViewById(R.id.cartViewAdd);
            mRemove = (Button)itemView.findViewById(R.id.cartViewRemove);
            mAmount.setText(String.valueOf(amount));
            onAddClick();
            onRemove();
        }

        public void bind(Product product) {
            mTitle.setText(product.getTitle());
            mPrice.setText(product.getPrice());
            mAmount.setText(String.valueOf(amount));

        }

        private void onAddClick() {
            mAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAmount.setText(String.valueOf(++amount));
                }
            });
        }

        private void onRemove() {
            mRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAmount.setText(String.valueOf(--amount));
                }
            });
        }
    }
}
