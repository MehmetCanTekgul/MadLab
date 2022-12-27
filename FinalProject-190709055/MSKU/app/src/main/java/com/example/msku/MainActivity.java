package com.example.msku;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText txtEmail = (EditText) findViewById(R.id.TxtEmail);
        EditText txtPassword= (EditText) findViewById(R.id.TxtPassword);

        Button btnLogin;
        btnLogin = findViewById(R.id.BtnMain);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                CollectionReference dr = firebaseFirestore.collection("Student Email");
                firebaseFirestore.collection("Student Email").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                if(  txtEmail.getText().toString().equals(document.get("Email"))){
                                    String id1= document.getId();
                                    String str = document.getId();
                                    FirebaseFirestore firebaseFirestore1 = FirebaseFirestore.getInstance();
                                    CollectionReference dr1 =  firebaseFirestore1.collection("Password");
                                    firebaseFirestore1.collection("Password").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                            if(task.isSuccessful()){
                                                for(QueryDocumentSnapshot document : task.getResult()){
                                                    if( txtPassword.getText().toString().equals(document.get("Password"))){
                                                        String id2 = document.getId();
                                                        if(id1.equals(id2)){

                                                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                                            intent.putExtra("message", str);
                                                            startActivity(intent);
                                                            break;
                                                        }else{
                                                            Toast.makeText(MainActivity.this, "Your password is wrong!!", Toast.LENGTH_SHORT).show();
                                                        }

                                                    }else{
                                                        Toast.makeText(MainActivity.this, "Your password is wrong!!", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                        }
                                    });
                                    break;
                                }else{
                                    Toast.makeText(MainActivity.this, "Please enter valid email!!", Toast.LENGTH_SHORT).show();
                                }
                                //Log.d(TAG, document.getId() + "=>" + document.get("Email"));
                            }
                        }else{
                            Log.w(TAG, "Error getting documents." , task.getException());
                        }
                    }
                });

            }
        });
        Button btnDownload = findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadImage().execute("https://pbs.twimg.com/profile_images/1190383908707274754/zOYB1Nyo_400x400.png");
            }
        });



    }

    public class DownloadImage extends AsyncTask<String, Void, Bitmap>{

        ImageView imageView = findViewById(R.id.imageView);
        @Override
        protected Bitmap doInBackground(String... strings) {

            Bitmap bitmap = null;
            URL url;
            HttpURLConnection httpURLConnection = null;

            InputStream in;
            try {
                url = new URL(strings[0]);
                httpURLConnection= (HttpURLConnection) url.openConnection();
                in = new BufferedInputStream(httpURLConnection.getInputStream());
                bitmap = BitmapFactory.decodeStream(in);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                httpURLConnection.disconnect();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if(bitmap != null){
                imageView.setImageBitmap(bitmap);
                Toast.makeText(getApplicationContext(), "Download is successful.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Download is failed!.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}