package com.example.xylophonetutorial;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Button easy, normal, hard, note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        easy = (Button) findViewById(R.id.easychooser);
        hard = (Button) findViewById(R.id.hardchooser);
        normal = (Button) findViewById(R.id.normalchooser);
        note = (Button) findViewById(R.id.testnote);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent (menu.this, statistical_note.class);
                startActivity(a);
            }
        });

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a = new Intent(menu.this, easy_chooser.class);
                startActivity(a);

            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(menu.this, hard_chooser.class);
                startActivity(a);
            }
        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(menu.this, normal_chooser.class);
                startActivity(a);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu_drawer, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_History) {
            Intent a = new Intent(menu.this, History.class);
            startActivity(a);
        }
        else if (id == R.id.nav_About) {
Intent a = new Intent(menu.this, about.class);
startActivity(a);

        }
        // else if (id == R.id.nav_Tutorial) {

   //     }
        else if (id == R.id.nav_easy) {
            Intent a = new Intent(menu.this, Details.class);
            startActivity(a);

        }
        else if (id == R.id.nav_normal) {
            Intent a = new Intent(menu.this, Normal_score.class);
            startActivity(a);

        }else if (id == R.id.nav_hard) {
            Intent a = new Intent(menu.this, Hard_score.class);
            startActivity(a);

        }else if (id == R.id.nav_statistical_report) {
            Intent a = new Intent(menu.this, Stattistical_Report.class);
            startActivity(a);

        }
        else if (id == R.id.nav_Composed) {
            Intent a = new Intent(menu.this, composed.class);
            startActivity(a);

        }else if (id == R.id.nav_Songlist) {
            Intent a = new Intent(menu.this, easy.class);
            startActivity(a);

        }



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
