package com.example.ticket4u;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Sell extends AppCompatActivity {
    private static final String TAG = "Sell";
    Button mButton_back,mButton_sell,mButton_Load;
    EditText mItemName,mItemPrice,mItemSold;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference itemRef  = db.collection("items").document();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        mButton_back = findViewById((R.id.buttonBack));
        mButton_sell = findViewById(R.id.buttonSell);
        mButton_Load = findViewById(R.id.buttonLoad);
        mItemName = findViewById((R.id.editTextItemName));
        mItemPrice = findViewById((R.id.editTextItemPrice));
        mItemSold = findViewById((R.id.editTextItemSold));

        mButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        mButton_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });

        mButton_Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getItem(view);
            }
        });

    }

//////////////////////////////////////////////////////////////////////////
//example for set value to collection, we generate automatic the ID documents.
//////////////////////////////////////////////////////////////////////////
    public void addItem(View v) {
        Boolean boolitemsold = Boolean.FALSE;
        String itemName = mItemName.getText().toString();
        String itemPrice = mItemPrice.getText().toString();
        String itemSold = mItemSold.getText().toString();
        if(itemSold =="Yes") boolitemsold = Boolean.TRUE;

        Map<String,Object> note = new HashMap<>();
        note.put("name",itemName);
        note.put("price",itemPrice);
        note.put("sold",itemSold);

        // db.document("Notebook/my first note");
        String docID=getID("items");
        itemRef.set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Sell.this, "item saved, document ID: "+docID, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Sell.this, "Error to saved item", Toast.LENGTH_SHORT).show();
                        Log.d(TAG,e.toString());
                    }
                });
    }

    //////////////////////////////////////////////////////////////////////////
//example for get value from collection
//////////////////////////////////////////////////////////////////////////
    public void getItem(View v) {
        Boolean boolitemsold = Boolean.FALSE;
        String itemName = mItemName.getText().toString();
        String itemPrice = mItemPrice.getText().toString();
        String itemSold = mItemSold.getText().toString();
        if(itemSold =="Yes") boolitemsold = Boolean.TRUE;

        Map<String,Object> note = new HashMap<>();
        note.put("name",itemName);
        note.put("price",itemPrice);
        note.put("sold",itemSold);
        itemRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){

                }else{
                    Toast.makeText(Sell.this, "Doc does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        // db.document("Notebook/my first note");
       /* db.collection("items").document().set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Sell.this, "item saved, document ID: "+docID, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Sell.this, "Error to saved item", Toast.LENGTH_SHORT).show();
                        Log.d(TAG,e.toString());
                    }
                });*/
    }


    //TODO: move to general class\library, because we use it in more classes.
    public String getID(String collectionName){
        return db.collection(collectionName).document().getId();
    }

}