package com.example.ticket4u;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button mButton_sell;
    Button mButton_serach;
    Button mButton_history;
    Button mButton_settings;
    Button mButton_logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton_sell = findViewById((R.id.button_sell));

        mButton_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Sell.class));
            }
        });
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut(); // logout
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}