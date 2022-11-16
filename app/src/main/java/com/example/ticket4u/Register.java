package com.example.ticket4u;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;


public class Register extends AppCompatActivity {
    EditText fullName,email,password,phone;
    Button registerButton;
    TextView alreadyLogin;
    FirebaseAuth fireBaseAuth;
    ProgressBar progressBar;
    //ssssss

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullName = findViewById((R.id.fullName));
        email = findViewById((R.id.email));
        password = findViewById((R.id.password));
        phone = findViewById((R.id.phone));
        registerButton = findViewById((R.id.registerBtn));
        alreadyLogin = findViewById(R.id.alreadyLogin);

        fireBaseAuth = FirebaseAuth.getInstance();              /* get current instance of firebase */
        progressBar = findViewById(R.id.progressBar);

    }

}