package com.example.cmd.pop.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmd.pop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by cmd on 10.12.17.
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText mMail,mPass,mPassConf;
    private Button mLogin,mRegister;
    private FirebaseAuth mAuth;
    private String mail,pass,passConf;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        mAuth = FirebaseAuth.getInstance();
        find();
        onClick();
    }

    private void find() {
        mMail = (EditText)findViewById(R.id.registerName);
        mPass = (EditText)findViewById(R.id.registerPassword);
        mPassConf = (EditText)findViewById(R.id.registerPasswordConfirmation);
        mLogin = (Button)findViewById(R.id.btnLoginRegister);
        mRegister = (Button)findViewById(R.id.btnRegisterRegister);
    }


    private void onClick() {
        mail = mMail.getText().toString();
        pass = mPass.getText().toString();
        passConf = mPassConf.getText().toString();
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail = mMail.getText().toString();
                pass = mPass.getText().toString();
                passConf = mPassConf.getText().toString();
                if(!isEmpty(mail) && !isEmpty(pass) && !isEmpty(passConf) ) {
                    if(TextUtils.equals(pass,passConf)) {
                        mAuth.createUserWithEmailAndPassword(mail,pass)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                            finish();
                                        } else {
                                            Toast.makeText(RegisterActivity.this, "Error registering....", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                    } else {
                        Toast.makeText(RegisterActivity.this, "Password didn't match.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "All fields need to be filled.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private boolean isEmpty(String name) {
        return TextUtils.isEmpty(name);
    }


}
