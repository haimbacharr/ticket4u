package com.example.ticket4u;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

enum ELogin {
    VALIDATE_SUCCESS,
    VALIDATE_EMAIL_EMPTY,
    VALIDATE_PASSWORD_EMPTY,
    VALIDATE_PASSWORD_SHORT;
}


public class Login extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button mLoginButton;
    TextView textIsNew, forgotTextLink;
    FirebaseAuth fireBaseAuth;
    ProgressBar progressBarLogin;

    ELogin validateLoginStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.emailLogin);
        mPassword = findViewById(R.id.passwordLogin);
        mLoginButton = findViewById(R.id.loginBtn);
        textIsNew = findViewById(R.id.textIsNewHere);
        fireBaseAuth = FirebaseAuth.getInstance();
        progressBarLogin = findViewById(R.id.progressBarLogin);
        forgotTextLink = findViewById(R.id.forgotPassword);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                validateLoginStatus = validatePasswordAndEmail(email,password);
                if(validateLoginStatus != ELogin.VALIDATE_SUCCESS){
                    Toast.makeText(Login.this, "Some fields wrong", Toast.LENGTH_SHORT).show();
                }
                else {
                    /* sign In to fireBase */
                    fireBaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressBarLogin.setVisibility(View.VISIBLE);
                                Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(Login.this, "There is not such a user", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        /* When click on "Already register? Login Here" go to Login activity */
        textIsNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });


        /* Forgot password method */
        forgotTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendRequestToResetEmailPassword(view);
            }
        });

    }


    /* Validate password and email */
    private ELogin validatePasswordAndEmail(String email, String password) {
        if(TextUtils.isEmpty(email)){
            mEmail.setError("Email is required.");
            return ELogin.VALIDATE_EMAIL_EMPTY;
        }
        else if(TextUtils.isEmpty(password)){
            mPassword.setError("Password is required.");
            return ELogin.VALIDATE_PASSWORD_EMPTY;
        }

        else if(password.length() < 6){
            mPassword.setError("Password must be >= 6 characters");
            return ELogin.VALIDATE_PASSWORD_SHORT;
        }

        return ELogin.VALIDATE_SUCCESS; // validate complete successfully
    }

    private void SendRequestToResetEmailPassword(View view) {
        EditText resetEmail = new EditText(view.getContext());
        AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
        passwordResetDialog.setTitle("Reset password?");
        passwordResetDialog.setMessage("Enter Your Email To Received Reset Link.");
        passwordResetDialog.setView(resetEmail);

        passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String mail = resetEmail.getText().toString();
                fireBaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Login.this, "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "Error! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //close the dialog window
            }
        });

        passwordResetDialog.create().show(); // open the dialog which describe before.
    }

}