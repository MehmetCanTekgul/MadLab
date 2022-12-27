package com.example.msku;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class FoodMenu extends AppCompatActivity {

    ImageButton btnBack;
    ImageButton btnHome;
    ImageButton btnPerson;

    TextView date1;
    TextView date2;
    TextView date3;
    TextView date4;
    TextView date5;

    TextView menu1;
    TextView menu2;
    TextView menu3;
    TextView menu4;
    TextView menu5;

    TextView time1;
    TextView time2;
    TextView time3;
    TextView time4;
    TextView time5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodmenu);

        date1 = findViewById(R.id.Date1);
        date2 = findViewById(R.id.Date2);
        date3 = findViewById(R.id.Date3);
        date4 = findViewById(R.id.Date4);
        date5 = findViewById(R.id.Date5);

        menu1 = findViewById(R.id.Menu1);
        menu2 = findViewById(R.id.Menu2);
        menu3 = findViewById(R.id.Menu3);
        menu4 = findViewById(R.id.Menu4);
        menu5 = findViewById(R.id.Menu5);

        time1 = findViewById(R.id.Time1);
        time2 = findViewById(R.id.Time2);
        time3 = findViewById(R.id.Time3);
        time4 = findViewById(R.id.Time4);
        time5 = findViewById(R.id.Time5);


        FirebaseFirestore fb = FirebaseFirestore.getInstance();
        fb.collection("Current Date").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        if(documentSnapshot.getId().equals("Monday")){
                            date1.setText(documentSnapshot.get("Day").toString());
                            menu1.setText(documentSnapshot.get("Ogun").toString());
                            time1.setText(documentSnapshot.get("Time").toString());
                        }else if(documentSnapshot.getId().equals("Tuesday")){
                            date2.setText(documentSnapshot.get("Day").toString());
                            menu2.setText(documentSnapshot.get("Ogun").toString());
                            time2.setText(documentSnapshot.get("Time").toString());
                        }else if(documentSnapshot.getId().equals("Wednesday")){
                            date3.setText(documentSnapshot.get("Day").toString());
                            menu3.setText(documentSnapshot.get("Ogun").toString());
                            time3.setText(documentSnapshot.get("Time").toString());
                        }else if(documentSnapshot.getId().equals("Thursday")){
                            date4.setText(documentSnapshot.get("Day").toString());
                            menu4.setText(documentSnapshot.get("Ogun").toString());
                            time4.setText(documentSnapshot.get("Time").toString());
                        }else if(documentSnapshot.getId().equals("Friday")){
                            date5.setText(documentSnapshot.get("Day").toString());
                            menu5.setText(documentSnapshot.get("Ogun").toString());
                            time5.setText(documentSnapshot.get("Time").toString());
                        }
                    }
                }else{
                    Log.d(TAG, "Error getting document!");
                }
            }
        });

        btnBack = findViewById(R.id.imgBtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodMenu.this, SecondActivity.class);
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
                Intent intent = new Intent(FoodMenu.this, SecondActivity.class);
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
                Intent intent = new Intent(FoodMenu.this, PersonalInformations.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });

    }

}
