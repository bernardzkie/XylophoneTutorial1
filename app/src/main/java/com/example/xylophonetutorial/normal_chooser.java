package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class normal_chooser extends AppCompatActivity {
ImageButton normalhome, lodonbridge, leronleronsinta, akoaymaylobo, marryhadalittlelamb, mrbean, oldmacdonald;
String l;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_chooser);
    lodonbridge = findViewById(R.id.londonbridge);
    normalhome = (ImageButton) findViewById(R.id.normalhome);
    leronleronsinta = findViewById(R.id.leronleronsinta);
    akoaymaylobo = findViewById(R.id.akoaymaylobo);
    marryhadalittlelamb = findViewById(R.id.marryhadalittlelamb);
    mrbean = findViewById(R.id.mrbean);
    oldmacdonald = findViewById(R.id.oldmcdonald);

normalhome.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent a = new Intent(normal_chooser.this, menu.class);
        startActivity(a);
    }
});
    lodonbridge.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
         l = "London Bridge";

            Intent a = new Intent(normal_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", l);
            startActivity(a);



        }
    });

    leronleronsinta.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            l = "Leron Leron Sinta";
            Intent a = new Intent(normal_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", l);

            startActivity(a);

        }
    });

    akoaymaylobo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            l = "Ako ay May Lobo";
            Intent a = new Intent(normal_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", l );
            startActivity(a);


        }
    });

    marryhadalittlelamb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            l = "Marry had a Little Lamb";
            Intent a = new Intent(normal_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", l);
            startActivity(a);



        }
    });

    mrbean.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            l = "Mr. Bean";
            Intent a = new Intent(normal_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", l);
            startActivity(a);


        }
    });


    oldmacdonald.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            l = "One Day";
            Intent a = new Intent(normal_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", l);
            startActivity(a);

        }
    });

    }
}
