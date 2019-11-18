package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.ActionBar;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class statistical_note extends AppCompatActivity {
    TextView asharp5,csharp6, dsharp6, fsharp6 , gsharp6, asharp6, csharp7, dsharp7, fsharp7, gsharp7;
    TextView a7, g7, f7, e7, d7, c7, b6, a6, g6, f6, e6, d6, c6, b5, a5, pattern;
    private ImageButton startbtn, playbtn;
    private MediaRecorder mRecorder;
    private MediaPlayer mPlayer;
    private static final String LOG_TAG = "AudioRecording";
    private static String mFileName = null;
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;
int back = 1;
int pausestop = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistical_note);
        asharp5 = (TextView) findViewById(R.id.Asharp5);
        pattern = (TextView) findViewById(R.id.notepatern);
        csharp6 = (TextView) findViewById(R.id.Csharp6);
        dsharp6= (TextView) findViewById(R.id.Dsharp6);
        fsharp6 = (TextView) findViewById(R.id.Fsharp6);
        gsharp6= (TextView) findViewById(R.id.Gsharp6);
        asharp6= (TextView) findViewById(R.id.Asharp6);
        csharp7= (TextView) findViewById(R.id.Csharp7);
        dsharp7= (TextView) findViewById(R.id.Dsharp7);
        fsharp7= (TextView) findViewById(R.id.Fsharp7);
        gsharp7= (TextView) findViewById(R.id.Gsharp7);
        a7= (TextView) findViewById(R.id.A7);
        g7= (TextView) findViewById(R.id.G7);
        f7= (TextView) findViewById(R.id.F7);
        e7= (TextView) findViewById(R.id.E7);
        d7= (TextView) findViewById(R.id.D7);
        c7= (TextView) findViewById(R.id.C7);
        b6= (TextView) findViewById(R.id.B6);
        a6= (TextView) findViewById(R.id.A6);
        g6= (TextView) findViewById(R.id.G6);
        f6= (TextView) findViewById(R.id.F6);
        e6= (TextView) findViewById(R.id.E6);
        d6= (TextView) findViewById(R.id.D6);
        c6= (TextView) findViewById(R.id.C6);
        b5= (TextView) findViewById(R.id.B5);
        a5= (TextView) findViewById(R.id.A5);
        startbtn = (ImageButton) findViewById(R.id.strt_record);
        playbtn = (ImageButton) findViewById(R.id.ply_record);

        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/AudioRecording.3gp";

        play();
        playbtn.setEnabled(false);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (back == 1) {
                    startbtn.setBackgroundResource(R.mipmap.stop_rec);
                    startaudio();
                    back = 0;

                    playbtn.setEnabled(false);
                } else  {
                    startbtn.setBackgroundResource(R.mipmap.start_rec);

                    stopaudio();
                    playbtn.setEnabled(true);
                    back = 1;



                }

            }
        });
         playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pausestop == 1){
                    playbtn();
                    playbtn.setBackgroundResource(R.mipmap.stop_play);
                    pausestop = 0;


                }
                else {
                    stopbtn();
                    playbtn.setBackgroundResource(R.mipmap.play_rec);
                    pausestop = 1;



                }




            }
        });





    }

    public void stopbtn(){


        mPlayer.release();
        mPlayer = null;

        Toast.makeText(getApplicationContext(),"Playing Audio Stopped", Toast.LENGTH_SHORT).show();


    }


public void playbtn(){

    mPlayer = new MediaPlayer();
    try {
        mPlayer.setDataSource(mFileName);
        mPlayer.prepare();
        mPlayer.start();
        Toast.makeText(getApplicationContext(), "Recording Started Playing", Toast.LENGTH_LONG).show();
    } catch (IOException e) {
        Log.e(LOG_TAG, "prepare() failed");
    }



}
public void stopaudio(){

    mRecorder.stop();
    mRecorder.release();
    mRecorder = null;
    Toast.makeText(getApplicationContext(), "Recording Stopped", Toast.LENGTH_LONG).show();



}
public void startaudio(){

    if(CheckPermissions()) {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mRecorder.setOutputFile(mFileName);
        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
        mRecorder.start();
        Toast.makeText(getApplicationContext(), "Recording Started", Toast.LENGTH_LONG).show();
            }



    else
    {
        RequestPermissions();
    }

}
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_AUDIO_PERMISSION_CODE:
                if (grantResults.length> 0) {
                    boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean permissionToStore = grantResults[1] ==  PackageManager.PERMISSION_GRANTED;
                    if (permissionToRecord && permissionToStore) {
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
    public boolean CheckPermissions() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }
    private void RequestPermissions() {
        ActivityCompat.requestPermissions(statistical_note.this,
                new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE}, REQUEST_AUDIO_PERMISSION_CODE);
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

            pattern.setText("A7");

            a7();


        }


    }

    private void processg2(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f" ,pitch2);
        if ((pitch2 >= 39.20 && pitch2 < 39.70)) {
            //e2
            pattern.setText("G#7");

            gsharp7();
        }


        else  if ((pitch2 >= 39 && pitch2 < 39.20)) {
            //e2

            pattern.setText("G7");

            g7();

        }
        else if ((pitch2 >= 38.75 && pitch2 < 39.00)) {
            //e2

            pattern.setText("F#7");

            fsharp7();
        }


        else if ((pitch2 >= 38 && pitch2 < 38.75)) {
            //e2
            pattern.setText("F7");

            f7();

        }

        else if ((pitch2 >= 37.45 && pitch2 < 38)) {
            //e2
            pattern.setText("E7");

            e7();
        }
        else if ((pitch2 >= 37 && pitch2 < 37.45)) {
            //e2
            pattern.setText("D#7");

dsharp7();
        }

        else if ((pitch2 >= 36.40 && pitch2 < 37)) {
            //e2
            pattern.setText("D7");

d7();
        }
        else if ((pitch2 >= 36.30 && pitch2 < 36.40)) {
            //e2


            pattern.setText("C#7");

csharp7();

        }

        else if ((pitch2 >= 35.80 && pitch2 < 36.30)) {
            //e2

            pattern.setText("C7");

c7();
        }
        else if ((pitch2 >= 35.50 && pitch2 < 35.80)) {
            //e2
            pattern.setText("B6");

b6();

        }

        else if ((pitch2 >= 35.17 && pitch2 < 35.50)) {
            //e2
            pattern.setText("A#6");

     asharp6();
        }

        else if ((pitch2 >= 34.90 && pitch2 < 35.17)) {
            //e2
            pattern.setText("A6");

a6();
        }
        else if ((pitch2 >= 34.70 && pitch2 < 34.90)) {
            //e2
            pattern.setText("G#6");

     gsharp6();
        }

        else if ((pitch2 >= 34.30 && pitch2 < 34.70)) {
            //e2

            pattern.setText("G6");

g6();

        }
        else if ((pitch2 >= 34.20 && pitch2 < 34.30)) {
            //e2
            pattern.setText("F#6");

fsharp6();
        }

        else if ((pitch2 >= 34.00 && pitch2 < 34.20)) {
            //e2
            pattern.setText("F6");
f6();
        }
        else if ((pitch2 >= 33.75 && pitch2 < 34.00)) {
            //e2
            pattern.setText("E6");
e6();
        }
        else if ((pitch2 >= 33.50 && pitch2 < 33.75)) {
            //e2
            pattern.setText("D#6");
dsharp6();
        }

        else if ((pitch2 >= 33.20 && pitch2 < 33.50)) {
            //e2
            pattern.setText("D6");
d6();
        }
        else if ((pitch2 >= 33.10 && pitch2 < 33.20)) {
            //e2
            pattern.setText("C#6");
csharp6();
        }

        else if ((pitch2 >= 32.90 && pitch2 < 33.10)) {
            //e2
            pattern.setText("C6");
c6();
        }
        else if ((pitch2 >= 33.85 && pitch2 < 33.90)) {
            //e2
            pattern.setText("B5");
b5();
        }
        else if ((pitch2 >= 32.82 && pitch2 < 33.85)) {
            //e2
            pattern.setText("A#5");

asharp5();
        }
        else if ((pitch2 >= 32.72 && pitch2 < 32.82)) {
            //e2
            pattern.setText("B5");

b5();
        }

        else if ((pitch2 >= 32.60 && pitch2 < 32.72)) {
            //e2
            pattern.setText("A#5");

asharp5();
        }  else if ((pitch2 >= 32.42 && pitch2 < 32.60)) {
            //e2
            pattern.setText("A5");

a5();
        }

        else if ((pitch2 >= 32.30 && pitch2 < 32.42)) {
            //e2
            pattern.setText("D#7");

dsharp7();
        }
        else if ((pitch2 >= 32.15 && pitch2 < 32.30)) {
            //e2
            pattern.setText("D7");

d7();
        }

        else if ((pitch2 >= 32.00 && pitch2 < 32.15)) {
            //e2
            pattern.setText("C#6");

csharp6();
        }

        else if ((pitch2 >= 31.80 && pitch2 < 32.00)) {
            //e2
            pattern.setText("A5");

a5();
        }

    }


    public void asharp5(){

        asharp5.setBackgroundResource(R.drawable.animation);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);




    }
    public void csharp6(){

        csharp6.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }

    public void dsharp6(){

        dsharp6.setBackgroundResource(R.drawable.animation);
        csharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void fsharp6(){

        fsharp6.setBackgroundResource(R.drawable.animation);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void gsharp6(){

        gsharp6.setBackgroundResource(R.drawable.animation);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void asharp6(){

        asharp6.setBackgroundResource(R.drawable.animation);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void csharp7(){

        csharp7.setBackgroundResource(R.drawable.animation);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        asharp5.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void dsharp7(){

        dsharp7.setBackgroundResource(R.drawable.animation);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        asharp5.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void fsharp7(){

        fsharp7.setBackgroundResource(R.drawable.animation);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        asharp5.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void gsharp7(){

        gsharp7.setBackgroundResource(R.drawable.animation);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        asharp5.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void a7(){

        a7.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void g7(){
        g7.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void f7(){
      f7.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void e7(){
       e7.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void d7(){
       d7.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void c7(){
        c7.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void b6(){
        b6.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void a6(){
        a6.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void g6(){
        g6.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }
    public void f6(){
        f6.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }




    public void e6(){
        e6.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }

    public void d6(){
        d6.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }

    public void c6(){
        c6.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }

    public void b5(){
        b5.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);
        a5.setBackgroundResource(R.drawable.bilog);





    }

    public void a5(){
        a5.setBackgroundResource(R.drawable.animation);
        asharp5.setBackgroundResource(R.drawable.bilog);
        csharp6.setBackgroundResource(R.drawable.bilog);
        dsharp6.setBackgroundResource(R.drawable.bilog);
        fsharp6.setBackgroundResource(R.drawable.bilog);
        gsharp6.setBackgroundResource(R.drawable.bilog);
        asharp6.setBackgroundResource(R.drawable.bilog);
        csharp7.setBackgroundResource(R.drawable.bilog);
        dsharp7.setBackgroundResource(R.drawable.bilog);
        fsharp7.setBackgroundResource(R.drawable.bilog);
        gsharp7.setBackgroundResource(R.drawable.bilog);
        g7.setBackgroundResource(R.drawable.bilog);
        f7.setBackgroundResource(R.drawable.bilog);
        e7.setBackgroundResource(R.drawable.bilog);
        d7.setBackgroundResource(R.drawable.bilog);
        c7.setBackgroundResource(R.drawable.bilog);
        b6.setBackgroundResource(R.drawable.bilog);
        a6.setBackgroundResource(R.drawable.bilog);
        g6.setBackgroundResource(R.drawable.bilog);
        f6.setBackgroundResource(R.drawable.bilog);
        e6.setBackgroundResource(R.drawable.bilog);
        d6.setBackgroundResource(R.drawable.bilog);
        c6.setBackgroundResource(R.drawable.bilog);
        b5.setBackgroundResource(R.drawable.bilog);
        a7.setBackgroundResource(R.drawable.bilog);





    }
}



