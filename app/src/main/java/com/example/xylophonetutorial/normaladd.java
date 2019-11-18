package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class normaladd extends AppCompatActivity {
database db;
ImageButton backsnormal;
Button savednormal;
EditText notesnormal, tittlenormal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normaladd);
        backsnormal = (ImageButton) findViewById(R.id.backsnormal);
        savednormal = (Button) findViewById(R.id.savenormal);
        notesnormal = (EditText) findViewById(R.id.notesnormal);
        tittlenormal = (EditText) findViewById(R.id.tittlenormal);
        db = new database(this);

        backsnormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(normaladd.this, normal.class);
                startActivity(a);
            }
        });

        savednormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry11 = tittlenormal.getText().toString();
                String newEntry22 = notesnormal.getText().toString();
                if(notesnormal.length()!= 0 || tittlenormal.length() != 0){
                    addNormal(newEntry11, newEntry22);
                    notesnormal.setText("");
                    tittlenormal.setText("");
                }else{
                    Toast.makeText(normaladd.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void addNormal(String newEntry11, String newEntry22) {
        boolean insert = db.addNormal(newEntry11, newEntry22);

        if(insert==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }


    }
}


