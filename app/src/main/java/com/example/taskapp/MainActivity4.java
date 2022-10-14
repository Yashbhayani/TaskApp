package com.example.taskapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    Button B1;
    ImageButton b1,b2,b3;
    EditText E1,E2,E3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main4);

        B1 = findViewById(R.id.button2);
        b1 =  findViewById(R.id.button3);
        b2 =  findViewById(R.id.button4);
        b3 =  findViewById(R.id.button5);
        E1 = findViewById(R.id.editTextTextPersonName);
        E2 = findViewById(R.id.editTextTextEmailAddress);
        E3 = findViewById(R.id.editTextTextPassword);


        B1.setOnClickListener(view -> {

            String e1 = E1.getText().toString();
            String e2 = E2.getText().toString();
            String e3 = E3.getText().toString();

            if(e1.equals("")) {
                E1.setError("Please Enter a Username");
            }else if(e2.equals("")) {
                E2.setError("Please Enter a Email Address");
            }else if(e3.equals("")){
                E3.setText("Please Enter a Password");
            }


            if (e1.equals("") || e2.equals("") || e3.equals("")) {
                Toast.makeText(MainActivity4.this, "Your Data is Null", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences asd = getSharedPreferences("my_f", Context.MODE_PRIVATE);
                SharedPreferences.Editor e = asd.edit();
                e.putString("Username",e1);
                e.putString("Email",e2);
                e.putString("Password",e3);
                e.apply();

               Intent A = new Intent(MainActivity4.this, MainActivity3.class);
               A.putExtra("key",e1);
               A.putExtra("key1",e2);
               A.putExtra("key2",e3);
               startActivity(A);
               finish();
           }
        });

        b1.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.google.com"));
            startActivity(i);
        });

        b2.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.facebook.com"));
            startActivity(i);
        });

        b3.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.twitter.com"));
            startActivity(i);
        });
    }
}