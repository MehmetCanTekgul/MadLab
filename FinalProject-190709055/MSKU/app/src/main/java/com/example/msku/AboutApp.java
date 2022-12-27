package com.example.msku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class AboutApp extends AppCompatActivity {

    ImageButton btnHelp;
    ImageButton btnBack;
    ImageButton btnHome;
    ImageButton btnPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        btnHelp = findViewById(R.id.imgBtnHelp);
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AboutApp.this, "Call us for issues...", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                FragmentManager fragmentManager =getSupportFragmentManager();
                Fragment fragment2 =fragmentManager.findFragmentByTag("second");
                if(fragment2 == null){
                    fragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, AboutAppWebFragment.class,
                            bundle,"second").addToBackStack("").commit();
                }else{
                    fragmentManager.popBackStack();
                }

            }
        });

        btnBack = findViewById(R.id.imgBtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutApp.this, SecondActivity.class);
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
                Intent intent = new Intent(AboutApp.this, SecondActivity.class);
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
                Intent intent = new Intent(AboutApp.this, PersonalInformations.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });
    }
}