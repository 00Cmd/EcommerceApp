package com.example.cmd.pop;

import com.example.cmd.pop.JavaClasses.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 19.11.17.
 */

public class Database {
    private FirebaseDatabase mDb;
    private DatabaseReference dbRef;
    private static Database sDatabase;

    public static Database getDatabase(DatabaseReference ref) {
        if(sDatabase == null) {
            sDatabase = new Database(ref);
        }
        return sDatabase;
    }

    public Database(DatabaseReference mReference) {
        this.mDb = FirebaseDatabase.getInstance();
        this.dbRef = mReference;
    }


    public void addToDatabase(Product pr) {
        dbRef = FirebaseDatabase.getInstance().getReference().child("products").child(pr.getStringId());
        dbRef.setValue(pr);

    }

    public List<Product> getProducts() {
        final List<Product> mProducts = new ArrayList<>();
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()) {
//                    GenericTypeIndicator<List<Product>> mIndicator = new GenericTypeIndicator<List<Product>>() {};
//                    Product pr = data.getValue(Product.class);
//                    mProducts.add(pr);
                    mProducts.add(data.getValue(Product.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return mProducts;
    }


}
