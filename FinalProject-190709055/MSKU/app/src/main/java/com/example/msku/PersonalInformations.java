package com.example.msku;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

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

public class PersonalInformations extends AppCompatActivity {

    ImageButton btnHome;
    Button btnLogout;
    TextView person1;
    TextView person2;
    TextView person3;
    TextView person4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_informations);



        person1 = findViewById(R.id.Person1);
        person2 = findViewById(R.id.Person2);
        person3 = findViewById(R.id.Person3);
        person4 = findViewById(R.id.Person4);

        Intent intentGet = getIntent();
        String str = intentGet.getStringExtra("message");
        FirebaseFirestore fb1 = FirebaseFirestore.getInstance();
        fb1.collection("Student Email").document(str).collection("Student Informations").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        person1.setText(documentSnapshot.get("Name").toString());
                        person2.setText(documentSnapshot.get("Surname").toString());
                        person3.setText(documentSnapshot.get("ID").toString());
                        person4.setText(documentSnapshot.get("Department").toString());
                    }
                }
            }
        });





        btnHome = findViewById(R.id.imgBtnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonalInformations.this, SecondActivity.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });

        btnLogout=findViewById(R.id.btnLogOut);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonalInformations.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}