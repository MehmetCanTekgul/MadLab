package com.example.msku;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

public class BalanceHistory extends AppCompatActivity {

    ImageButton btnBack;
    ImageButton btnHome;
    ImageButton btnPerson;
    TextView txtAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_history);

        btnBack = findViewById(R.id.imgBtnBack);
        btnHome = findViewById(R.id.imgBtnHome);
        btnPerson = findViewById(R.id.imgBtnPerson);
        txtAmount = findViewById(R.id.txtBalanceHistoryAmount);

        Intent intentGet = getIntent();
        String str = intentGet.getStringExtra("message");

        FirebaseFirestore fb=FirebaseFirestore.getInstance();
        fb.collection("Student Email").document(str).collection("Balance").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        if(documentSnapshot.getId().equals(str)){
                            txtAmount.setText(documentSnapshot.get("Balance History").toString());
                            Intent intent = new Intent(getApplicationContext(), MakeRezervation.class);
                            intent.putExtra("message_history", documentSnapshot.get("Balance History").toString());
                            startActivity(intent);
                        }
                    }
                }
            }
        });


        btnBack = findViewById(R.id.imgBtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BalanceHistory.this, SecondBalanceActivity.class);
                Intent intentGet = getIntent();
                String str =intentGet.getStringExtra("message");
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });

        btnHome = findViewById(R.id.imgBtnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BalanceHistory.this, SecondActivity.class);
                Intent intentGet = getIntent();
                String str =intentGet.getStringExtra("message");
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });

        btnPerson = findViewById(R.id.imgBtnPerson);
        btnPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGet = getIntent();
                String str =intentGet.getStringExtra("message");
                Intent intent = new Intent(BalanceHistory.this, PersonalInformations.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });
    }
}