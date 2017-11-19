package com.example.cmd.pop.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cmd.pop.Adapters.MainViewAdapter;
import com.example.cmd.pop.JavaClasses.MockData;
import com.example.cmd.pop.JavaClasses.Product;
import com.example.cmd.pop.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondProductFragment extends Fragment {
    private static final String TAG = "SecondProductFragment";
    private RecyclerView mView;


    public SecondProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second_product_layout, container, false);
        mView = (RecyclerView)v.findViewById(R.id.secondProductRecyclerView);
        List<Product> mProducts = MockData.getProductData();
        mView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        MainViewAdapter adapter = new MainViewAdapter(mProducts,getActivity());
        mView.setAdapter(adapter);
        return v;
    }

}
