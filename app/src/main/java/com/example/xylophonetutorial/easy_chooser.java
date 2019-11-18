package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import java.io.ByteArrayOutputStream;

public class easy_chooser extends AppCompatActivity {
ImageButton twinkle_twinkle, happy_birthday, incy_wincy, baba_blacksheep, Silent_night, jingle_bells, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_chooser);
        home = (ImageButton) findViewById(R.id.easyhome);
        twinkle_twinkle = (ImageButton) findViewById(R.id.star);
        happy_birthday = (ImageButton) findViewById(R.id.happybirthday);
        incy_wincy = (ImageButton) findViewById(R.id.incywincy);
        baba_blacksheep = (ImageButton) findViewById(R.id.sheepbaba);
        Silent_night = (ImageButton) findViewById(R.id.silent);
        jingle_bells = (ImageButton) findViewById(R.id.jinglebells);
home.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent a = new Intent(easy_chooser.this, menu.class);
        startActivity(a);
    }
});
    twinkle_twinkle.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String k = "Twinkle Twinkle Little Star";


            Intent a = new Intent(easy_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", k);
            startActivity(a);

        }
    });
    happy_birthday.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String k = "Happy Birthday";

            Intent b = new Intent(easy_chooser.this, easy_format_songs.class);
            b.putExtra("clickable", k );

            startActivity(b);
        }
    });
    incy_wincy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s = "Incy Wincy";

            Intent a = new Intent(easy_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", s);

            startActivity(a);
        }
    });
    baba_blacksheep.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String b = "Ba Ba Black Sheep";

            Intent a = new Intent(easy_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", b);

            startActivity(a);
        }
    });
    Silent_night.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String q = "Silent Night";

            Intent a = new Intent(easy_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", q);

            startActivity(a);
        }
    });
    jingle_bells.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String  j = "Jingle Bells";

            Intent a = new Intent(easy_chooser.this, easy_format_songs.class);
            a.putExtra("clickable", j);

            startActivity(a);
        }
    });




    }
}
