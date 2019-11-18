package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class easy extends AppCompatActivity {
ImageButton adds;
database myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        adds = (ImageButton) findViewById(R.id.adds);
        ListView listView = (ListView) findViewById(R.id.data);
        myDB = new database(this);


        //populate an ArrayList<String> from the database and then view it
        final ArrayList<String> theList = new ArrayList <>();




        Cursor data = myDB.GetTittle();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()) {
                theList.add(data.getString(1) + "\n \n" + data.getString(2));


                ListAdapter listAdapter = new ArrayAdapter<>(this, R.layout.lustview_easy, R.id.listing, theList);
                listView.setAdapter(listAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String listviewcontent = theList.get(i);


                        Intent a = new Intent(easy.this, easy_costumized.class);
                        a.putExtra("clickable", listviewcontent);

                        startActivity(a);
                    }
                });
            }
        }


        adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(easy.this, easyadd.class);
                startActivity(a);
            }
        });


    }
}
