package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

public class easy_costumized extends AppCompatActivity {
    TextView tittle, noteplayed, notepatern;
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

        setContentView(R.layout.activity_easy_costumized);
        startbtn = (ImageButton) findViewById(R.id.strt_record);
        playbtn = (ImageButton) findViewById(R.id.ply_record);

        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/AudioRecording.3gp";


        notepatern = (TextView) findViewById(R.id.notepatern);
        tittle = (TextView) findViewById(R.id.tittle);
        noteplayed = (TextView) findViewById(R.id.played_notes);
        tittle.setText(getIntent().getStringExtra("clickable"));

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
                notepatern.setText("A7");

//                noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

                }


            }





        private void processg2 ( float pitch2){
            pitch2 = (pitch2 / 350) + 30;

            String b = String.format("%.2f", pitch2);
            if ((pitch2 >= 39.20 && pitch2 < 39.70)) {
                notepatern.setText("G#7");
  //              noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());
                //g#7

            } else if ((pitch2 >= 39 && pitch2 < 39.20)) {
                //g7
                notepatern.setText("G7");
    //            noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 38.75 && pitch2 < 39.00)) {
                //f#7
                notepatern.setText("F#7");
      //          noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 38 && pitch2 < 38.75)) {
                //f7
                notepatern.setText("F7");
        //        noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 37.45 && pitch2 < 38)) {
                //e7
                notepatern.setText("E7");
          //      noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 37 && pitch2 < 37.45)) {
                //d#7
                notepatern.setText("D#7");
 //               noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 36.40 && pitch2 < 37)) {
                //d7
                notepatern.setText("D7");
   //             noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());


            } else if ((pitch2 >= 36.30 && pitch2 < 36.40)) {
                //c#7
                notepatern.setText("C#7");
     //           noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 35.80 && pitch2 < 36.30)) {
                //c7
                notepatern.setText("C7");
       //         noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 35.50 && pitch2 < 35.80)) {
                //b6
                notepatern.setText("B6");
 //               noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 35.17 && pitch2 < 35.50)) {
                //a#6
                notepatern.setText("A#6");
   //             noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 34.90 && pitch2 < 35.17)) {
                //a6
                notepatern.setText("A6");
     //           noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 34.70 && pitch2 < 34.90)) {
                //g#6
                notepatern.setText("G#6");
 //               noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 34.30 && pitch2 < 34.70)) {
                //g6
                notepatern.setText("G6");
   //             noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());


            } else if ((pitch2 >= 34.20 && pitch2 < 34.30)) {
                //f#6
                notepatern.setText("F#6");
     //           noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 34.00 && pitch2 < 34.20)) {
                //f6
                notepatern.setText("F6");
       //         noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 33.75 && pitch2 < 34.00)) {
                //e6
                notepatern.setText("E6");
         //       noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 33.50 && pitch2 < 33.75)) {
                //d#6
                notepatern.setText("D#6");
           //     noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 33.20 && pitch2 < 33.50)) {
                //d6
                notepatern.setText("D6");
             //   noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 33.10 && pitch2 < 33.20)) {
                //c#6
                notepatern.setText("C#6");
               // noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 32.90 && pitch2 < 33.10)) {
                //c6
                notepatern.setText("C6");
 //               noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 33.85 && pitch2 < 33.90)) {
                //b5
                notepatern.setText("B5");
   //             noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());



            } else if ((pitch2 >= 32.82  && pitch2 < 33.85)) {
                //a#5
                notepatern.setText("A#5");
     //           noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 32.72 && pitch2 < 32.82)) {
                //b5
                notepatern.setText("B5");
       //         noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 32.60 && pitch2 < 32.72)) {
                //a#5
                notepatern.setText("A#5");
         //       noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 32.42 && pitch2 < 32.60)) {
                //a5
                notepatern.setText("A5");
           //     noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 32.30 && pitch2 < 32.42 )) {
                //d#7
                notepatern.setText("D#7");
 //               noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 32.15 && pitch2 < 32.30)) {
                //d7
                notepatern.setText("D7");
   //             noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 32.00 && pitch2 < 32.15)) {
                //c#6
                notepatern.setText("C#6");
     //           noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

            } else if ((pitch2 >= 31.80 && pitch2 < 32.00)) {
                //a5
                notepatern.setText("A5");
       //         noteplayed.setText(noteplayed.getText() + notepatern.getText().toString());

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
        ActivityCompat.requestPermissions(easy_costumized.this,
                new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE}, REQUEST_AUDIO_PERMISSION_CODE);
    }



}




