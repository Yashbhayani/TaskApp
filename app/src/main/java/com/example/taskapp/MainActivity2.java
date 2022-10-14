package com.example.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    Animation topAnim;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        imageView = findViewById(R.id.imageView5);

        imageView.setAnimation(topAnim);


        long delayMillis;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent b = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(b);
                finish();
            }
        },delayMillis=3500);


    }
}