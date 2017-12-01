package com.example.cmd.pop.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cmd.pop.Activitys.PageAdapterActivity;
import com.example.cmd.pop.Adapters.MainViewAdapter;
import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;
import com.example.cmd.pop.RecyclerItemClickListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
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
    public class MainViewFragment extends Fragment {
        private static final String TAG = "MainViewFragment";
        private RecyclerView mView;
        private MainViewAdapter mainViewAdapter;
        private List<Product> mProducts;
        private DatabaseReference mRef;


        public MainViewFragment() {
//            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            mRef = FirebaseDatabase.getInstance().getReference().child("products");
            mRef.keepSynced(true);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_main_view, container, false);
            mView = (RecyclerView)v.findViewById(R.id.mainViewRecyclerView);
            mView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
            updateList();
            mainViewAdapter = new MainViewAdapter(mProducts,getActivity());
            mView.setAdapter(mainViewAdapter);
            onItemClikc();
            return v;
        }


        private void onItemClikc() {
            mView.addOnItemTouchListener( new RecyclerItemClickListener(getActivity(), mView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent i = new Intent(getActivity(), PageAdapterActivity.class);
                            Bundle bundle = new Bundle();
                            ArrayList<Product> mProductList = new ArrayList<Product>();
                            mProductList.addAll(mProducts);
                            bundle.putParcelableArrayList("productList",mProductList);
                            i.putExtras(bundle);
                            getActivity().startActivity(i);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));
        }

    private void updateList() {

            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    mProducts.add(dataSnapshot.getValue(Product.class));
                    mainViewAdapter.notifyDataSetChanged();

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    Product product = dataSnapshot.getValue(Product.class);
                    int index = getItemPosition(product);
                    mRef.setValue(index,product);
                    mainViewAdapter.notifyItemChanged(index);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    Product product = dataSnapshot.getValue(Product.class);
                    int index = getItemPosition(product);
                    mProducts.remove(index);
                    mainViewAdapter.notifyItemRemoved(index);
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

//        mRef = FirebaseDatabase.getInstance().getReference().child("products");
//        mProducts = new ArrayList<>();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//        mProducts = Db.getDatabase(getActivity(),mRef).getProducts();
//        mAdapter.setData(mProducts);

            }
//        }).start();

//    }
}
