package com.example.taskapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    TextView textView;
    ImageButton b1,b2,b3;
    EditText E1,E2;
    Button B1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);

        E1 = findViewById(R.id.editTextTextPersonName);
        E2 = findViewById(R.id.editTextTextPassword);
        textView = findViewById(R.id.textView8);
        b1 = findViewById(R.id.button3);
        b2 = findViewById(R.id.button4);
        b3 = findViewById(R.id.button5);
        B1 = findViewById(R.id.button2);
        SharedPreferences asd = getSharedPreferences("my_f", Context.MODE_PRIVATE);
        String k1 = asd.getString("Username",null);
        String k2 = asd.getString("Password",null);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String A1 = E1.getText().toString();
                String A2 = E2.getText().toString();

                if(A1.equals(""))
                {
                    E1.setError("Please Enter a Username");
                }else if(A2.equals("")) {
                    E2.setError("Please Enter a PassWord");
                }


                if(A1.equals("") || A2.equals(""))
                {
                    Toast.makeText(MainActivity3.this, "You are a not Define Username and Password", Toast.LENGTH_SHORT).show();
                }else {
                    if(A1.equals(k1) && A2.equals(k2)) {
                        Intent i = new Intent(MainActivity3.this,MainActivity5.class);
                        startActivity(i);
                        finish();
                    }else {
                        if(!A1.equals(k1)) {
                            if(!A2.equals(k2)) {
                                Toast.makeText(MainActivity3.this, "Username and Password Wrong", Toast.LENGTH_SHORT).show();
                            }else {
                            Toast.makeText(MainActivity3.this, "Your Username is Wrong", Toast.LENGTH_SHORT).show();
                            }
                        }else if(!A2.equals(k2)) {
                            Toast.makeText(MainActivity3.this, "Your PassWord is Wrong", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity3.this, "Username and Password Wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }

        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent A = new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(A);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.google.com"));
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.facebook.com"));
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.twitter.com"));
                startActivity(i);
            }
        });
    }
}