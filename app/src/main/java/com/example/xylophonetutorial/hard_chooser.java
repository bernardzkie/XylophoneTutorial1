package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class hard_chooser extends AppCompatActivity {
ImageButton daysofchristmas, isntshelovely, hardhome, angpaskoaysumapit, paroparongbukid, ikaw, sunshine;
String l;

@Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hard_chooser);
        hardhome = (ImageButton) findViewById(R.id.hardhome);
        daysofchristmas = findViewById(R.id.daysofchristmas);
        isntshelovely = findViewById(R.id.isntsheloveby);
        angpaskoaysumapit = findViewById(R.id.angpaskoaysumapit);
        paroparongbukid = findViewById(R.id.paroparongbukid);
        ikaw = findViewById(R.id.ikaw);
        sunshine = findViewById(R.id.sunshine);

hardhome.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent a = new Intent(hard_chooser.this, menu.class);
        startActivity(a);
    }
});
        daysofchristmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = "12 Days of Christmas";

                Intent a = new Intent(hard_chooser.this, easy_format_songs.class);
                a.putExtra("clickable", l);
                startActivity(a);



            }
        });

        isntshelovely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = "Isn't She Lovely";
                Intent a = new Intent(hard_chooser.this, easy_format_songs.class);
                a.putExtra("clickable", l);

                startActivity(a);

            }
        });

        angpaskoaysumapit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = "Ang Pasko ay Sumapit";
                Intent a = new Intent(hard_chooser.this, easy_format_songs.class);
                a.putExtra("clickable", l );
                startActivity(a);


            }
        });

        paroparongbukid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = "Paro Parong Bukid";
                Intent a = new Intent(hard_chooser.this, easy_format_songs.class);
                a.putExtra("clickable", l);
                startActivity(a);



            }
        });

        ikaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = "Ikaw";
                Intent a = new Intent(hard_chooser.this, easy_format_songs.class);
                a.putExtra("clickable", l);
                startActivity(a);


            }
        });


        sunshine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                l = "Sunshine";
                Intent a = new Intent(hard_chooser.this, easy_format_songs.class);
                a.putExtra("clickable", l);
                startActivity(a);

            }
        });

    }
}
