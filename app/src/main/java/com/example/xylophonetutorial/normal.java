package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class normal extends AppCompatActivity {
ImageButton back, addnormal;
ListView normaldata;
database myDB;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

    back = (ImageButton) findViewById(R.id.backsss);
    addnormal = (ImageButton) findViewById(R.id.addnormal);
       listView = (ListView) findViewById(R.id.normaldata);
        ListView listView =  findViewById(R.id.normaldata);
        myDB = new database(this);


        //populate an ArrayList<String> from the database and then view it
        final ArrayList<String> List = new ArrayList<>();




        Cursor data = myDB.GetNormal();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()) {
                List.add(data.getString(1) + "\n \n" + data.getString(2));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, List);
                listView.setAdapter(listAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String listviewcontent = List.get(i);


                        Intent a = new Intent(normal.this, menu.class);
                        a.putExtra("clickable", listviewcontent);

                        startActivity(a);
                    }
                });
            }




        }





        back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent a = new Intent(normal.this, chooser.class);
            startActivity(a);
        }
    });
addnormal.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent a = new Intent(normal.this, normaladd.class);
        startActivity(a);
    }
});



    }
}
