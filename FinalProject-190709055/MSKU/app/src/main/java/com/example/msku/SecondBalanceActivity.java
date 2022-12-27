package com.example.msku;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SecondBalanceActivity extends AppCompatActivity {

    Button btnLoad;
    Button btnHistory;
    ImageButton btnBack;
    ImageButton btnHome;
    ImageButton btnPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondbalance);

        btnHistory = findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGet = getIntent();
                String str =intentGet.getStringExtra("message");
                Intent intent = new Intent(SecondBalanceActivity.this, BalanceHistory.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });

        btnLoad=findViewById(R.id.btnLoading);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.ziraatbank.com.tr/tr/dijital-bankacilik/atm");
                Intent intentLoad = new Intent(Intent.ACTION_VIEW, uri);
                Intent intentGet = getIntent();
                String str =intentGet.getStringExtra("message");
                intentLoad.putExtra("message", str);
                startActivity(intentLoad);
            }
        });

        btnBack = findViewById(R.id.imgBtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondBalanceActivity.this, SecondActivity.class);
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
                Intent intent = new Intent(SecondBalanceActivity.this, SecondActivity.class);
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
                Intent intent = new Intent(SecondBalanceActivity.this, PersonalInformations.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });

    }

}
