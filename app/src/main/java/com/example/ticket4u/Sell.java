package com.example.ticket4u;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;

public class Sell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firest
        setContentView(R.layout.activity_sell);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }
}