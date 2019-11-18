package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class easyadd extends AppCompatActivity {
Button saved;
ImageButton back;
EditText notes, tittle;
database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easyadd);
    back = (ImageButton) findViewById(R.id.backs);
    saved = (Button) findViewById(R.id.save);
    notes = (EditText) findViewById(R.id.notes);
    tittle = (EditText) findViewById(R.id.tittle);
        db = new database(this);

    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent a = new Intent(easyadd.this, easy.class);
            startActivity(a);
        }
    });

saved.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String newEntry1 = tittle.getText().toString();
        String newEntry2 = notes.getText().toString();
        if(notes.length()!= 0 || tittle.length() != 0){
            AddData(newEntry1, newEntry2);
            notes.setText("");
            tittle.setText("");
        }else{
            Toast.makeText(easyadd.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
        }

    }
});
    }

    private void AddData(String newEntry1, String newEntry2) {
        boolean insertData = db.addData(newEntry1, newEntry2);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }


    }
}
