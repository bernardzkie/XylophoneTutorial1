package com.example.xylophonetutorial;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

public class Test extends AppCompatActivity {
    TextView asharp5,csharp6, dsharp6, fsharp6 , gsharp6, asharp6, csharp7, dsharp7, fsharp7, gsharp7;
    TextView a7, g7, f7, e7, d7, c7, b6, a6, g6, f6, e6, d6, c6, b5, a5;
    Button play;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        asharp5 = (TextView) findViewById(R.id.asharp5);
        csharp6 = (TextView) findViewById(R.id.csharp6);
        dsharp6= (TextView) findViewById(R.id.dsharp6);
        fsharp6 = (TextView) findViewById(R.id.fsharp6);
        gsharp6= (TextView) findViewById(R.id.gsharp6);
        asharp6= (TextView) findViewById(R.id.asharp6);
        csharp7= (TextView) findViewById(R.id.csharp7);
        dsharp7= (TextView) findViewById(R.id.dsharp7);
        fsharp7= (TextView) findViewById(R.id.fsharp7);
        gsharp7= (TextView) findViewById(R.id.gsharp7);
        a7= (TextView) findViewById(R.id.a7);
        g7= (TextView) findViewById(R.id.g7);
        f7= (TextView) findViewById(R.id.f7);
        e7= (TextView) findViewById(R.id.e7);
        d7= (TextView) findViewById(R.id.d7);
        c7= (TextView) findViewById(R.id.c7);
        b6= (TextView) findViewById(R.id.b6);
        a6= (TextView) findViewById(R.id.a6);
        g6= (TextView) findViewById(R.id.g6);
        f6= (TextView) findViewById(R.id.f6);
        e6= (TextView) findViewById(R.id.e6);
        d6= (TextView) findViewById(R.id.d6);
        c6= (TextView) findViewById(R.id.c6);
        b5= (TextView) findViewById(R.id.b5);
        a5= (TextView) findViewById(R.id.a5);
        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play();
            }
        });

    }









    public void play() {

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


    private void processa3(float pitch2note) {
        pitch2note = (pitch2note / 350) + 10;
        String a = String.format("%.2f", pitch2note);

        if ((pitch2note >= 20.00 && pitch2note < 21.00)) {
            //a7

            a7.setText(a);
a7();

        }


    }

    private void processg2(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f" ,pitch2);
        if ((pitch2 >= 39.20 && pitch2 < 39.70)) {
            //e2
            gsharp7.setText(b);
            gsharp7();
        }


        else  if ((pitch2 >= 39 && pitch2 < 39.20)) {
            //e2

            g7.setText(b);
       g7();

        }
        else if ((pitch2 >= 38.75 && pitch2 < 39.00)) {
            //e2

            fsharp7.setText(b);
       fsharp7();
        }


        else if ((pitch2 >= 38 && pitch2 < 38.75)) {
            //e2

            f7.setText(b);
        f7();
        }

        else if ((pitch2 >= 37.45 && pitch2 < 38)) {
            //e2
            e7.setText(b);
        e7();
        }
        else if ((pitch2 >= 37 && pitch2 < 37.45)) {
            //e2
            dsharp7.setText(b);
        dsharp7();
        }

        else if ((pitch2 >= 36.40 && pitch2 < 37)) {
            //e2

            d7.setText(b);
        d7();
        }
        else if ((pitch2 >= 36.30 && pitch2 < 36.40)) {
            //e2
            csharp7.setText(b);
        csharp7();
        }

        else if ((pitch2 >= 35.80 && pitch2 < 36.30)) {
            //e2

            c7.setText(b);
        c7();
        }
        else if ((pitch2 >= 35.50 && pitch2 < 35.80)) {
            //e2
            b6.setText(b);
        b6();
        }

        else if ((pitch2 >= 35.17 && pitch2 < 35.50)) {
            //e2
            asharp6.setText(b);
        asharp6();
        }

        else if ((pitch2 >= 34.90 && pitch2 < 35.17)) {
            //e2

            a6.setText(b);
        a6();
        }
        else if ((pitch2 >= 34.70 && pitch2 < 34.90)) {
            //e2
            gsharp6.setText(b);
        gsharp6();
        }

        else if ((pitch2 >= 34.30 && pitch2 < 34.70)) {
            //e2

            g6.setText(b);
        g6();

        }
        else if ((pitch2 >= 34.20 && pitch2 < 34.30)) {
            //e2

            fsharp6.setText(b);
        fsharp6();
        }

        else if ((pitch2 >= 34.00 && pitch2 < 34.20)) {
            //e2

            f6.setText(b);
        f6();
        }
        else if ((pitch2 >= 33.75 && pitch2 < 34.00)) {
            //e2

            e6.setText(b);
        e6();
        }
        else if ((pitch2 >= 33.50 && pitch2 < 33.75)) {
            //e2

            dsharp6.setText(b);
        dsharp6();
        }

        else if ((pitch2 >= 33.20 && pitch2 < 33.50)) {
            //e2

            d6.setText(b);
        d6();
        }
        else if ((pitch2 >= 33.10 && pitch2 < 33.20)) {
            //e2

            csharp6.setText(b);
        csharp6();
        }

        else if ((pitch2 >= 32.90 && pitch2 < 33.10)) {
            //e2

            c6.setText(b);
        c6();
        }
        else if ((pitch2 >= 33.85 && pitch2 < 33.90)) {
            //e2

            b5.setText(b);

        b5();


        }
        else if ((pitch2 >= 32.82 && pitch2 < 33.85)) {
            //e2

            asharp5.setText(b);
        asharp5();
        }
        else if ((pitch2 >= 32.72 && pitch2 < 32.82)) {
            //e2

            b5.setText(b);
        b5();
        }

        else if ((pitch2 >= 32.60 && pitch2 < 32.72)) {
            //e2

            asharp5.setText(b);
        asharp5();
        }  else if ((pitch2 >= 32.42 && pitch2 < 32.60)) {
            //e2

            a5.setText(b);

        a5();
        }

        else if ((pitch2 >= 32.30 && pitch2 < 32.42)) {
            //e2

            dsharp7.setText(b);
        dsharp7();
        }
        else if ((pitch2 >= 32.15 && pitch2 < 32.30)) {
            //e2

            d7.setText(b);
        d7();
        }

        else if ((pitch2 >= 32.00 && pitch2 < 32.15)) {
            //e2

            csharp6.setText(b);
        csharp6();
        }

        else if ((pitch2 >= 31.80 && pitch2 < 32.00)) {
            //e2

            a5.setText(b);
        a5();
        }

    }
    public void asharp5(){


        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        a7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void csharp6(){


        asharp5.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        a7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }

    public void dsharp6(){


        csharp6.setText("0");
        asharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        a7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void fsharp6(){


        csharp6.setText("0");
        dsharp6.setText("0");
        asharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        a7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void gsharp6(){


        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        asharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        a7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void asharp6(){


        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp5.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        a7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void csharp7(){


        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        asharp5.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        a7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void dsharp7(){


        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        asharp5.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        a7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void fsharp7(){


        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        asharp5.setText("0");
        gsharp7.setText("0");
        a7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void gsharp7(){


        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        asharp5.setText("0");
        a7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void a7(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void g7(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        a7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void f7(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        a7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void e7(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        a7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void d7(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        a7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void c7(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        a7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void b6(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        a7.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void a6(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a7.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void g6(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        a7.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }
    public void f6(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        a7.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }




    public void e6(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        a7.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }

    public void d6(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        a7.setText("0");
        c6.setText("0");
        b5.setText("0");
        a5.setText("0");





    }

    public void c6(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        a7.setText("0");
        b5.setText("0");
        a5.setText("0");





    }

    public void b5(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        a7.setText("0");
        a5.setText("0");





    }

    public void a5(){

        asharp5.setText("0");
        csharp6.setText("0");
        dsharp6.setText("0");
        fsharp6.setText("0");
        gsharp6.setText("0");
        asharp6.setText("0");
        csharp7.setText("0");
        dsharp7.setText("0");
        fsharp7.setText("0");
        gsharp7.setText("0");
        g7.setText("0");
        f7.setText("0");
        e7.setText("0");
        d7.setText("0");
        c7.setText("0");
        b6.setText("0");
        a6.setText("0");
        g6.setText("0");
        f6.setText("0");
        e6.setText("0");
        d6.setText("0");
        c6.setText("0");
        b5.setText("0");
        a7.setText("0");





    }
}
