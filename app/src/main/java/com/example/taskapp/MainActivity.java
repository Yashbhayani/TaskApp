package com.example.taskapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Click to Sign up Button and go to next Page", Toast.LENGTH_SHORT).show();
        button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent a =  new Intent(MainActivity.this,MainActivity2.class);
            startActivity(a);
            finish();
        });
    }
}