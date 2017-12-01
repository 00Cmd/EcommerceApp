package com.example.cmd.pop.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cmd.pop.Adapters.MainViewAdapter;
import com.example.cmd.pop.Adapters.SecondProductAdapter;
import com.example.cmd.pop.JavaClasses.MockData;
import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondProductFragment extends Fragment {
    private static final String TAG = "SecondProductFragment";
    private List<Product> mProducts;
    private SecondProductAdapter mAdapter;
    private DatabaseReference mRef;
    private RecyclerView mView;


    public SecondProductFragment() {
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mRef = FirebaseDatabase.getInstance().getReference().child("products");
        mRef.keepSynced(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second_product_layout, container, false);
        mView = (RecyclerView)v.findViewById(R.id.secondProductRecyclerView);
        mView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        updateList();
        mAdapter = new SecondProductAdapter(mProducts,getActivity());
        mView.setAdapter(mAdapter);
        return v;
    }

    private void updateList() {
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mProducts.add(dataSnapshot.getValue(Product.class));
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Product product = dataSnapshot.getValue(Product.class);
                int index = getItemPosition(product);
                mRef.setValue(index,product);
                mAdapter.notifyItemChanged(index);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Product product = dataSnapshot.getValue(Product.class);
                int index = getItemPosition(product);
                mProducts.remove(index);
                mAdapter.notifyItemRemoved(index);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private int getItemPosition(Product product) {
        int index = -1;
        for (int i = 0; i < mProducts.size() ; i++) {
            int key1 = Integer.valueOf(mProducts.get(i).getStringId());
            int key2 = Integer.valueOf(product.getStringId());
            if(key1 == key2) {
                index = i;
                break;
            }
        }
        return index;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mProducts == null) {
            mProducts = new ArrayList<>();
        }
        mProducts.clear();
    }

}
