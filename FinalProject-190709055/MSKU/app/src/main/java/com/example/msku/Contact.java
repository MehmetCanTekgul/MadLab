package com.example.msku;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Contact extends AppCompatActivity {

    ImageButton btnBack;
    ImageButton btnHome;
    ImageButton btnPerson;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        WebView webView;
        webView=findViewById(R.id.webView);
        webView.loadUrl("https://yks.mu.edu.tr/Hakkinda.aspx" );
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tv=findViewById(R.id.txtphone);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Intent intentGet = getIntent();
                String str =intentGet.getStringExtra("message");
                intent.putExtra("message", str);
                intent.setData(Uri.parse("tel:(0252) 211 10 00"));
                startActivity(intent);
            }
        });

        btnBack = findViewById(R.id.imgBtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contact.this, SecondActivity.class);
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
                Intent intent = new Intent(Contact.this, SecondActivity.class);
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
                Intent intent = new Intent(Contact.this, PersonalInformations.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });


    }


}
