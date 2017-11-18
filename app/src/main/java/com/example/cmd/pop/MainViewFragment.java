package com.example.cmd.pop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainViewFragment extends Fragment {
    private static final String TAG = "MainViewFragment";
    private RecyclerView mView;


    public MainViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_view, container, false);
        mView = (RecyclerView)v.findViewById(R.id.mainViewRecyclerView);
        List<Product> mProducts = MockData.getProductData();
        mView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        MainViewAdapter adapter = new MainViewAdapter(mProducts,getActivity());
        mView.setAdapter(adapter);
        return v;
    }

}
