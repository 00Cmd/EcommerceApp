package com.example.cmd.pop;

import android.content.Context;
import android.widget.Toast;

import com.example.cmd.pop.JavaClasses.Product;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by cmd on 29.11.17.
 */

public class Db {
    private DatabaseReference mRef;
    private Context ctx;
    private static Db sDb;
    private List<Product> mProduct;

    public static Db getDatabase(Context ctx, DatabaseReference mRef) {
        if(sDb == null) {
            sDb = new Db(ctx,mRef);
        }
        return sDb;
    }

    private Db(Context ctx,DatabaseReference mRef) {
        this.ctx = ctx;
        this.mRef = mRef;
    }

    public List<Product> getProducts() {
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> dataSnapshotIterator = dataSnapshot.getChildren().iterator();
                Product product = null;
                while (dataSnapshotIterator.hasNext()) {
                    DataSnapshot dataSnapshotChild = dataSnapshotIterator.next();
                    product = dataSnapshotChild.getValue(Product.class);
                    mProduct.add(product);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        return mProduct;
    }
}
