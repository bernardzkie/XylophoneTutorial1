package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

public class composed extends AppCompatActivity {
    Button save, add, clear;
    database db = new database(this);
    TextView notepatern, noteadded, tittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composed);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        clear = (Button) findViewById(R.id.clearnote);
        save = (Button) findViewById(R.id.savenote);
        add = (Button) findViewById(R.id.addnote);
        notepatern = findViewById(R.id.notepatern);
        noteadded = findViewById(R.id.noteadded);
        tittle = findViewById(R.id.tittle);
        play();
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteadded.setText("");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                noteadded.setText(noteadded.getText().toString() + " " + notepatern.getText().toString());


            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry1 = tittle.getText().toString();
                String newEntry2 = noteadded.getText().toString();
                if (noteadded.length() != 0 || tittle.length() != 0) {
                    AddData(newEntry1, newEntry2);
                    noteadded.setText("");
                    tittle.setText("");
                } else {
                    Toast.makeText(composed.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void AddData(String newEntry1, String newEntry2) {
        boolean insertData = db.addData(newEntry1, newEntry2);

        if (insertData == true) {
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }


    }



    public void play(){

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            processa3(pitch2note);
                            processg2(pitch2note);


                        }
                    });


                }

            };

            AudioProcessor pitchProcessor = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 22050, 1024, pdh);
            dispatcher.addAudioProcessor(pitchProcessor);

            Thread audioThread = new Thread(dispatcher, "Audio Thread");
            audioThread.start();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//sharp1#
//sharp1#


    private void processa3( float pitch2note){
        pitch2note = (pitch2note / 350) + 10;
        String a = String.format("%.2f", pitch2note);

        if ((pitch2note >= 20.00 && pitch2note < 20.26)) {
            //a7
            notepatern.setText("A7 ");



        }


    }





    private void processg2 ( float pitch2){
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);
        if ((pitch2 >= 39.20 && pitch2 < 39.70)) {
            notepatern.setText("G#7");

            //g#7

        } else if ((pitch2 >= 39 && pitch2 < 39.20)) {
            //g7
            notepatern.setText("G7");


        } else if ((pitch2 >= 38.75 && pitch2 < 39.00)) {
            //f#7
            notepatern.setText("F#7");


        } else if ((pitch2 >= 38 && pitch2 < 38.75)) {
            //f7
            notepatern.setText("F7");


        } else if ((pitch2 >= 37.45 && pitch2 < 38)) {
            //e7
            notepatern.setText("E7");


        } else if ((pitch2 >= 37 && pitch2 < 37.45)) {
            //d#7
            notepatern.setText("D#7");


        } else if ((pitch2 >= 36.40 && pitch2 < 37)) {
            //d7
            notepatern.setText("D7");



        } else if ((pitch2 >= 36.30 && pitch2 < 36.40)) {
            //c#7
            notepatern.setText("C#7");


        } else if ((pitch2 >= 35.80 && pitch2 < 36.30)) {
            //c7
            notepatern.setText("C7");


        } else if ((pitch2 >= 35.50 && pitch2 < 35.80)) {
            //b6
            notepatern.setText("B6");

        } else if ((pitch2 >= 35.17 && pitch2 < 35.50)) {
            //a#6
            notepatern.setText("A#6");


        } else if ((pitch2 >= 34.90 && pitch2 < 35.17)) {
            //a6
            notepatern.setText("A6");


        } else if ((pitch2 >= 34.70 && pitch2 < 34.90)) {
            //g#6
            notepatern.setText("G#6");


        } else if ((pitch2 >= 34.30 && pitch2 < 34.70)) {
            //g6
            notepatern.setText("G6");



        } else if ((pitch2 >= 34.20 && pitch2 < 34.30)) {
            //f#6
            notepatern.setText("F#6");


        } else if ((pitch2 >= 34.00 && pitch2 < 34.20)) {
            //f6
            notepatern.setText("F6");


        } else if ((pitch2 >= 33.75 && pitch2 < 34.00)) {
            //e6
            notepatern.setText("E6");


        } else if ((pitch2 >= 33.50 && pitch2 < 33.75)) {
            //d#6
            notepatern.setText("D#6");


        } else if ((pitch2 >= 33.20 && pitch2 < 33.50)) {
            //d6
            notepatern.setText("D6");


        } else if ((pitch2 >= 33.10 && pitch2 < 33.20)) {
            //c#6
            notepatern.setText("C#6");


        } else if ((pitch2 >= 32.90 && pitch2 < 33.10)) {
            //c6
            notepatern.setText("C6");


        } else if ((pitch2 >= 33.85 && pitch2 < 33.90)) {
            //b5
            notepatern.setText("B5");




        } else if ((pitch2 >= 32.82 && pitch2 < 33.85)) {
            //a#5
            notepatern.setText("A#5");

        } else if ((pitch2 >= 32.72 && pitch2 < 32.82)) {
            //b5
            notepatern.setText("B5");


        } else if ((pitch2 >= 32.60 && pitch2 < 32.72)) {
            //a#5
            notepatern.setText("A#5");


        } else if ((pitch2 >= 32.42 && pitch2 < 32.60)) {
            //a5
            notepatern.setText("A5");


        } else if ((pitch2 >= 32.30 && pitch2 < 32.42 )) {
            //d#7
            notepatern.setText("D#7");


        } else if ((pitch2 >= 32.15 && pitch2 < 32.30)) {
            //d7
            notepatern.setText("D7");


        } else if ((pitch2 >= 32.00 && pitch2 < 32.15)) {
            //c#6
            notepatern.setText("C#6");


        } else if ((pitch2 >= 31.80 && pitch2 < 32.00)) {
            //a5
            notepatern.setText("A5");


        }

    }
}
