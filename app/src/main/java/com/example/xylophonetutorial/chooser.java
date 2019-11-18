package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class chooser extends AppCompatActivity {
Button easy, normal, hard, note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);
    easy = (Button) findViewById(R.id.easy);
        hard = (Button) findViewById(R.id.hard);
        normal = (Button) findViewById(R.id.normal);
        note = (Button) findViewById(R.id.test);


note.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent a = new Intent (chooser.this, statistical_note.class);
        startActivity(a);
    }
});

        easy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

Intent a = new Intent(chooser.this, easy_chooser.class);
startActivity(a);

        }
    });
    hard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent a = new Intent(chooser.this, hard_chooser.class);
            startActivity(a);


        }
    });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(chooser.this, normal_chooser.class);
                startActivity(a);


            }
        });


    }
}
