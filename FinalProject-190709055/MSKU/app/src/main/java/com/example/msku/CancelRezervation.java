package com.example.msku;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class CancelRezervation extends AppCompatActivity {

    ImageButton btnBack;
    ImageButton btnHome;
    ImageButton btnPerson;
    Button btnCancel;
    TextView selectDate1;
    TextView selectDate2;
    TextView selectDate3;
    TextView selectDate4;
    TextView selectDate5;

    Switch switch1;
    Switch switch2;
    Switch switch3;
    Switch switch4;
    Switch switch5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_rezervation);

        btnCancel = findViewById(R.id.CancelButton);
        selectDate1 = findViewById(R.id.SelectDate1);
        selectDate2 = findViewById(R.id.SelectDate2);
        selectDate3 = findViewById(R.id.SelectDate3);
        selectDate4 = findViewById(R.id.SelectDate4);
        selectDate5 = findViewById(R.id.SelectDate5);

        Intent intentGet = getIntent();
        String str =intentGet.getStringExtra("message");

        FirebaseFirestore fb1 = FirebaseFirestore.getInstance();
        fb1.collection("Current Date").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot document : task.getResult()){
                        if(document.getId().equals("Monday")){
                            selectDate1.setText(document.get("Day").toString());
                        }else if(document.getId().equals("Tuesday")){
                            selectDate2.setText(document.get("Day").toString());
                        }else if(document.getId().equals("Wednesday")){
                            selectDate3.setText(document.get("Day").toString());
                        }else if(document.getId().equals("Thursday")){
                            selectDate4.setText(document.get("Day").toString());
                        }else{
                            selectDate5.setText(document.get("Day").toString());
                        }
                    }
                }else{
                    Log.d(ContentValues.TAG, "Error getting document.");
                }
            }
        });

        switch1 = findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b == true) {
                            btnCancel.setBackgroundColor(Color.rgb(0, 188, 212));
                            b = false;
                        } else {
                            btnCancel.setBackgroundColor(Color.rgb(33, 150, 243));
                            b = true;
                        }
                    }

                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        FirebaseFirestore fb = FirebaseFirestore.getInstance();
                        fb.collection("Student Email").document(str).collection("Rezervations").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                boolean isExist = false;
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                        if (documentSnapshot.get("Day").equals(selectDate1.getText().toString())) {
                                            Map<String, Object> update = new HashMap<>();
                                            update.put("Day", FieldValue.delete());
                                            DocumentReference df = fb.collection("Student Email").document(str).collection("Rezervations").document(documentSnapshot.getId());
                                            df.update(update).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()){
                                                        Toast.makeText(CancelRezervation.this, "Rezervation is succesfully canceled.", Toast.LENGTH_SHORT).show();
                                                    }else{
                                                        Toast.makeText(CancelRezervation.this, "Error occured, try again.", Toast.LENGTH_SHORT).show();
                                                        Log.w(TAG, "Error getting documentReference");
                                                    }
                                                }
                                            });
                                            isExist = true;
                                            break;
                                        }
                                    }
                                    if (!isExist) {
                                        Toast.makeText(CancelRezervation.this, "You don't have rezervation on that date!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });
        switch2 = findViewById(R.id.switch2);
        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b == true) {
                            btnCancel.setBackgroundColor(Color.rgb(0, 188, 212));
                            b = false;
                        } else {
                            btnCancel.setBackgroundColor(Color.rgb(33, 150, 243));
                            b = true;
                        }
                    }

                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        FirebaseFirestore fb = FirebaseFirestore.getInstance();
                        fb.collection("Student Email").document(str).collection("Rezervations").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                boolean isExist = false;
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                        if (documentSnapshot.get("Day").equals(selectDate2.getText().toString())) {
                                            Map<String, Object> update = new HashMap<>();
                                            update.put("Day", FieldValue.delete());
                                            DocumentReference df = fb.collection("Student Email").document(str).collection("Rezervations").document(documentSnapshot.getId());
                                            df.update(update).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(CancelRezervation.this, "Rezervation is succesfully canceled.", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(CancelRezervation.this, "Error occured, try again.", Toast.LENGTH_SHORT).show();
                                                        Log.w(TAG, "Error getting documentReference");
                                                    }
                                                }
                                            });
                                            isExist = true;
                                            break;
                                        }
                                    }
                                    if (!isExist) {
                                        Toast.makeText(CancelRezervation.this, "You don't have rezervation on that date!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });

        switch3 = findViewById(R.id.switch3);
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b == true) {
                            btnCancel.setBackgroundColor(Color.rgb(0, 188, 212));
                            b = false;
                        } else {
                            btnCancel.setBackgroundColor(Color.rgb(33, 150, 243));
                            b = true;
                        }
                    }

                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        FirebaseFirestore fb = FirebaseFirestore.getInstance();
                        fb.collection("Student Email").document(str).collection("Rezervations").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                boolean isExist = false;
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                        if (documentSnapshot.get("Day").equals(selectDate3.getText().toString())) {
                                            Map<String, Object> update = new HashMap<>();
                                            update.put("Day", FieldValue.delete());
                                            DocumentReference df = fb.collection("Student Email").document(str).collection("Rezervations").document(documentSnapshot.getId());
                                            df.update(update).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(CancelRezervation.this, "Rezervation is succesfully canceled.", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(CancelRezervation.this, "Error occured, try again.", Toast.LENGTH_SHORT).show();
                                                        Log.w(TAG, "Error getting documentReference");
                                                    }
                                                }
                                            });
                                            isExist = true;
                                            break;
                                        }
                                    }
                                    if (!isExist) {
                                        Toast.makeText(CancelRezervation.this, "You don't have rezervation on that date!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });

        switch4 = findViewById(R.id.switch4);
        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b == true) {
                            btnCancel.setBackgroundColor(Color.rgb(0, 188, 212));
                            b = false;
                        } else {
                            btnCancel.setBackgroundColor(Color.rgb(33, 150, 243));
                            b = true;
                        }
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        FirebaseFirestore fb = FirebaseFirestore.getInstance();
                        fb.collection("Student Email").document(str).collection("Rezervations").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                boolean isExist = false;
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                        if (documentSnapshot.get("Day").equals(selectDate4.getText().toString())) {
                                            Map<String, Object> update = new HashMap<>();
                                            update.put("Day", FieldValue.delete());
                                            DocumentReference df = fb.collection("Student Email").document(str).collection("Rezervations").document(documentSnapshot.getId());
                                            df.update(update).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(CancelRezervation.this, "Rezervation is succesfully canceled.", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(CancelRezervation.this, "Error occured, try again.", Toast.LENGTH_SHORT).show();
                                                        Log.w(TAG, "Error getting documentReference");
                                                    }
                                                }
                                            });
                                            isExist = true;
                                            break;
                                        }
                                    }
                                    if (!isExist) {
                                        Toast.makeText(CancelRezervation.this, "You don't have rezervation on that date!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });

        switch5 = findViewById(R.id.switch5);
        switch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b == true) {
                            btnCancel.setBackgroundColor(Color.rgb(0, 188, 212));
                            b = false;
                        } else {
                            btnCancel.setBackgroundColor(Color.rgb(33, 150, 243));
                            b = true;
                        }
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        FirebaseFirestore fb = FirebaseFirestore.getInstance();
                        fb.collection("Student Email").document(str).collection("Rezervations").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                boolean isExist = false;
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                        if (documentSnapshot.get("Day").equals(selectDate5.getText().toString())) {
                                            Map<String, Object> update = new HashMap<>();
                                            update.put("Day", FieldValue.delete());
                                            DocumentReference df = fb.collection("Student Email").document(str).collection("Rezervations").document(documentSnapshot.getId());
                                            df.update(update).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(CancelRezervation.this, "Rezervation is succesfully canceled.", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(CancelRezervation.this, "Error occured, try again.", Toast.LENGTH_SHORT).show();
                                                        Log.w(TAG, "Error getting documentReference");
                                                    }
                                                }
                                            });
                                            isExist = true;
                                            break;
                                        }
                                    }
                                    if (!isExist) {
                                        Toast.makeText(CancelRezervation.this, "You don't have rezervation on that date!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });


        btnBack = findViewById(R.id.imgBtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CancelRezervation.this, SecondRezervationActivity.class);
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
                Intent intent = new Intent(CancelRezervation.this, SecondActivity.class);
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
                Intent intent = new Intent(CancelRezervation.this, PersonalInformations.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });
    }
}