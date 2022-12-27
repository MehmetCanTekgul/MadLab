package com.example.msku;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        Button btnRezervation;
        Button btnBalance;
        Button btnMenu;
        Button btnContact;
        Button btnAbout;
        ImageButton btnPerson;


        btnRezervation=findViewById(R.id.btnRezervation);
        btnRezervation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForGet = getIntent();
                String str = intentForGet.getStringExtra("message");
                Intent intent=new Intent(SecondActivity.this,SecondRezervationActivity.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });

        btnBalance=findViewById(R.id.btnBalance);
        btnBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForGet = getIntent();
                String str = intentForGet.getStringExtra("message");
                Intent intent=new Intent(SecondActivity.this,SecondBalanceActivity.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });


        btnMenu=findViewById(R.id.btnFoodMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForGet = getIntent();
                String str = intentForGet.getStringExtra("message");
                Intent intent = new Intent(SecondActivity.this, FoodMenu.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });

        btnContact=findViewById(R.id.btnContact);
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForGet = getIntent();
                String str = intentForGet.getStringExtra("message");
                Intent intent=new Intent(SecondActivity.this, Contact.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });

        btnAbout=findViewById(R.id.btnAboutApp);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForGet = getIntent();
                String str = intentForGet.getStringExtra("message");
                Intent intent = new Intent(SecondActivity.this, AboutApp.class);
                intent.putExtra("message",str);
                startActivity(intent);
            }
        });

        btnPerson = findViewById(R.id.imgBtnPerson);
        btnPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForGet = getIntent();
                String str = intentForGet.getStringExtra("message");
                Intent intent = new Intent(SecondActivity.this, PersonalInformations.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });

    }


}
