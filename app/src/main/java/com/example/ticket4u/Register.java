package com.example.ticket4u;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

enum ERegister {
    VALIDATE_SUCCESS,
    VALIDATE_EMAIL_EMPTY,
    VALIDATE_PASSWORD_EMPTY,
    VALIDATE_PASSWORD_SHORT;
}

public class Register extends AppCompatActivity {
    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterButton;
    TextView alreadyLogin;
    FirebaseAuth fireBaseAuth;
    ProgressBar progressBarRegister;

    ERegister validateRegisterStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFullName = findViewById((R.id.fullName));
        mEmail = findViewById((R.id.emailRegsiter));
        mPassword = findViewById((R.id.passwordRegister));
        mPhone = findViewById((R.id.phone));
        mRegisterButton = findViewById((R.id.registerBtn));
        alreadyLogin = findViewById(R.id.alreadyLogin);

        fireBaseAuth = FirebaseAuth.getInstance();              /* get current instance of firebase */
        progressBarRegister = findViewById(R.id.progressBarRegister);

       if(fireBaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                validateRegisterStatus = validatePasswordAndEmail(email,password);
                if(validateRegisterStatus != ERegister.VALIDATE_SUCCESS){
                    Toast.makeText(Register.this, "Some fields wrong", Toast.LENGTH_SHORT).show();
                }
                else {
                    RegisterUserToFireBase(email,password);// register user to data base
                }

            }
        });

       /* When click on "Already register? Login Here" go to Login activity */
        alreadyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


    }

    private ERegister validatePasswordAndEmail(String email, String password) {
        if(TextUtils.isEmpty(email)){
            mEmail.setError("Email is required.");
            return ERegister.VALIDATE_EMAIL_EMPTY;
        }
        else if(TextUtils.isEmpty(password)){
            mPassword.setError("Password is required.");
            return ERegister.VALIDATE_PASSWORD_EMPTY;
        }

        else if(password.length() < 6){
            mPassword.setError("Password must be >= 6 characters");
            return ERegister.VALIDATE_PASSWORD_SHORT;
        }

        else progressBarRegister.setVisibility(View.VISIBLE);
        return ERegister.VALIDATE_SUCCESS; // validate complete successfully
    }


     private void RegisterUserToFireBase(String email,String password){

         /* register the user in firebase */
         fireBaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){
                     Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(getApplicationContext(),MainActivity.class));
                 }
             }
         });
     }
}