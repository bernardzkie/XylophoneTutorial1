package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    public static int timeout = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent a = new Intent (MainActivity.this, menu.class);
                startActivity(a);
                finish();
            }
        }, timeout);
    }

    }

