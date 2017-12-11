package com.example.cmd.pop.Fragments;

import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.cmd.pop.R;

import java.net.URI;

import static android.app.Activity.RESULT_OK;

/**
 * Created by cmd on 10.12.17.
 */

public class AddProductFragment extends Fragment {
    private static final int IMAGE_REQUEST = 1;

    private String imagePath;
    private EditText mTitle,mPrice;
    private Button mBtn,mUpload;
    private ImageView mImage;
    public AddProductFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_product_fragment,container,false);
        find(v);
        return v;
    }

    private void find(View v) {
        mTitle = (EditText)v.findViewById(R.id.singleProductTitle);
        mPrice = (EditText)v.findViewById(R.id.singleProductPrice);
        mBtn = (Button) v.findViewById(R.id.addProductSelectImageBtn);
        mImage = (ImageView)v.findViewById(R.id.addProductImage);
        mUpload = (Button)v.findViewById(R.id.uploadBtn);
    }

    private void onClick() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                getActivity().startActivityForResult(Intent.createChooser(intent,"Select Picture"), IMAGE_REQUEST);

            }
        });

        mUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mTitle.getText().toString();
                String price = mPrice.getText().toString();
                if (!title.isEmpty() && !price.isEmpty()) {

                }

            }



        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == IMAGE_REQUEST && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            String path = getPath(imageUri);
            mImage.setImageBitmap(BitmapFactory.decodeFile(path));

        }
    }

    public String getPath(Uri uri) {
        int column_index = 0;
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getActivity().getContentResolver().query(uri,projection, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
            column_index = cursor.getColumnIndex(projection[0]);
            imagePath = cursor.getString(column_index);
            cursor.close();
        }
        return cursor.getString(column_index);
    }
}
