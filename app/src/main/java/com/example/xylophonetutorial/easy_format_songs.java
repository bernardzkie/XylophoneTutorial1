package com.example.xylophonetutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class easy_format_songs extends AppCompatActivity {
    TextView tittle, efnotepatern, multiplier;
    TextView asharp5, csharp6, dsharp6, fsharp6, gsharp6, asharp6, csharp7, dsharp7, fsharp7, gsharp7;
    TextView a7, g7, f7, e7, d7, c7, b6, a6, g6, f6, e6, d6, c6, b5, a5;
    int setter = 0;

    Button progressionplay;
    int total = 0;
    Dialog dialog;
    Thread theads;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_format_songs);
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tittle = (TextView) findViewById(R.id.tittle);
        efnotepatern = (TextView) findViewById(R.id.efnotepatern);
        progressionplay = (Button) findViewById(R.id.progressionplay);
        multiplier = (TextView) findViewById(R.id.multiplier);
        asharp5 = (TextView) findViewById(R.id.efasharp5);

        csharp6 = (TextView) findViewById(R.id.efcsharp6);
        dsharp6 = (TextView) findViewById(R.id.efdsharp6);
        fsharp6 = (TextView) findViewById(R.id.effsharp6);
        gsharp6 = (TextView) findViewById(R.id.efgsharp6);
        asharp6 = (TextView) findViewById(R.id.efasharp6);
        csharp7 = (TextView) findViewById(R.id.efcsharp7);
        dsharp7 = (TextView) findViewById(R.id.efdsharp7);
        fsharp7 = (TextView) findViewById(R.id.effsharp7);
        gsharp7 = (TextView) findViewById(R.id.efgsharp7);
        a7 = (TextView) findViewById(R.id.efa7);
        g7 = (TextView) findViewById(R.id.efg7);
        f7 = (TextView) findViewById(R.id.eff7);
        e7 = (TextView) findViewById(R.id.efe7);
        d7 = (TextView) findViewById(R.id.efd7);
        c7 = (TextView) findViewById(R.id.efc7);
        b6 = (TextView) findViewById(R.id.efb6);
        a6 = (TextView) findViewById(R.id.efa6);
        g6 = (TextView) findViewById(R.id.efg6);
        f6 = (TextView) findViewById(R.id.eff6);
        e6 = (TextView) findViewById(R.id.efe6);
        d6 = (TextView) findViewById(R.id.efd6);
        c6 = (TextView) findViewById(R.id.efc6);
        b5 = (TextView) findViewById(R.id.efb5);
        a5 = (TextView) findViewById(R.id.efa5);
        tittle.setText(getIntent().getStringExtra("clickable"));
        dialog = new Dialog(this);
        theads = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {

                    try {


                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                            }
                        });


                    } catch (InterruptedException e) {
                        e.printStackTrace();


                    }


                }


            }


        };


// chooser of button when the next process to play

        progressionplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (setter == 0){

                if (tittle.getText().equals("Twinkle Twinkle Little Star")) {
                    setter = 1;

                    multiplier.setText("C6 X2");
               progressionplay.setVisibility(View.GONE);
                    progressionplay.setVisibility(View.INVISIBLE);

                    efnotepatern.setTextColor(Color.WHITE);
                    theads.start();
                    play();
                    c6();
                    twinkle();
                } else if (tittle.getText().equals("Happy Birthday")) {
                    multiplier.setText("D6 X2");
                    setter = 1;

                    progressionplay.setVisibility(View.GONE);

                    efnotepatern.setTextColor(Color.WHITE);
                    play();
                    theads.start();
                    progressionplay.setVisibility(View.INVISIBLE);

                    d6();
                    happybirthday();
                } else if (tittle.getText().equals("Incy Wincy")) {
                    multiplier.setText("C6 X3");
                    setter = 1;
                    progressionplay.setVisibility(View.GONE);

                    efnotepatern.setTextColor(Color.WHITE);
                    play();
                    theads.start();

                    c6();
                    incywincy();
                    progressionplay.setVisibility(View.INVISIBLE);

                } else if (tittle.getText().equals("Ba Ba Black Sheep")) {
                    multiplier.setText("C6 X2");
                    progressionplay.setVisibility(View.GONE);
                    efnotepatern.setTextColor(Color.WHITE);
                    setter = 1;

                    blacksheep();
                    play();
                    theads.start();

                    c6();
                    progressionplay.setVisibility(View.INVISIBLE);

                } else if (tittle.getText().equals("Silent Night")) {
                    multiplier.setText("G6 X1");
                    silentnight();
                    progressionplay.setVisibility(View.GONE);

                    setter = 1;

                    efnotepatern.setTextColor(Color.WHITE);
                    play();
                    theads.start();

                    g6();
                    progressionplay.setVisibility(View.INVISIBLE);

                } else if (tittle.getText().equals("Jingle Bells")) {
                    progressionplay.setVisibility(View.GONE);

                    efnotepatern.setTextColor(Color.WHITE);
                    multiplier.setText("B6 X7");
                    setter = 1;

                    jinglebell();
                    play();
                    theads.start();

                    b6();
                    progressionplay.setVisibility(View.INVISIBLE);

                } else if (tittle.getText().equals("Ako ay May Lobo")) {

                    progressionplay.setVisibility(View.GONE);
                    efnotepatern.setTextColor(Color.WHITE);
                    setter = 1;

                    multiplier.setText("A6 X3");
                    ako_ay_may_lobo();
                    play();
                    theads.start();
                    a6();
                    progressionplay.setVisibility(View.INVISIBLE);


                } else if (tittle.getText().equals("Marry had a Little Lamb")) {

                    efnotepatern.setTextColor(Color.WHITE);
                    progressionplay.setVisibility(View.GONE);
                    multiplier.setText("E6 X1");
                    marry_had_a_little_lamb();
                    play();
                    setter = 1;

                    theads.start();
                    e6();
                    progressionplay.setVisibility(View.INVISIBLE);


                } else if (tittle.getText().equals("Leron Leron Sinta")) {

                    efnotepatern.setTextColor(Color.WHITE);
                    multiplier.setText("G6 X2");
                    progressionplay.setVisibility(View.GONE);
                    leron_leron_sinta();
                    play();
                    theads.start();
                    setter = 1;

                    g6();
                    progressionplay.setVisibility(View.INVISIBLE);


                } else if (tittle.getText().equals("One Day")) {

                    efnotepatern.setTextColor(Color.WHITE);
                    progressionplay.setVisibility(View.GONE);
                    multiplier.setText("C6 X2");
                    one_day();
                    setter = 1;

                    play();
                    theads.start();
                    c6();
                    progressionplay.setVisibility(View.INVISIBLE);


                } else if (tittle.getText().equals("London Bridge")) {

                    progressionplay.setVisibility(View.GONE);
                    efnotepatern.setTextColor(Color.WHITE);
                    multiplier.setText("G6 X1");
                    london_bridge();
                    setter = 1;

                    play();
                    theads.start();
                    g6();
                    progressionplay.setVisibility(View.INVISIBLE);


                } else if (tittle.getText().equals("Mr. Bean")) {

                    efnotepatern.setTextColor(Color.WHITE);
                    progressionplay.setVisibility(View.GONE);
                    multiplier.setText("A5 X2");
                    mr_bean();
                    setter = 1;

                    play();
                    theads.start();
                    a5();
                    progressionplay.setVisibility(View.INVISIBLE);


                } else if (tittle.getText().equals("12 Days of Christmas")) {

                    efnotepatern.setTextColor(Color.WHITE);
                    progressionplay.setVisibility(View.GONE);
                    multiplier.setText("B6 X3");
                    days_of_christmas();
                    play();
                    setter = 1;

                    theads.start();
                    b6();
                    progressionplay.setVisibility(View.INVISIBLE);


                } else if (tittle.getText().equals("Isn't She Lovely")) {

                    efnotepatern.setTextColor(Color.WHITE);
                    multiplier.setText("G#6 X1");
                    progressionplay.setVisibility(View.GONE);
                    isnt_she_lovely();
                    setter = 1;

                    play();
                    theads.start();
                    gsharp6();
                    progressionplay.setVisibility(View.INVISIBLE);

                } else if (tittle.getText().equals("Ang Pasko ay Sumapit")) {

                    efnotepatern.setTextColor(Color.WHITE);
                    progressionplay.setVisibility(View.GONE);
                    multiplier.setText("C6 X1");
                    ang_pasko_ay_sumapit();
                    setter = 1;

                    play();
                    theads.start();
                    c6();
                    progressionplay.setVisibility(View.INVISIBLE);


                } else if (tittle.getText().equals("Paro Parong Bukid")) {

                    efnotepatern.setTextColor(Color.WHITE);
                    progressionplay.setVisibility(View.GONE);
                    multiplier.setText("D6 X4");
                    setter = 1;

                    paro_parong_bukid();
                    play();
                    theads.start();
                    d6();
                    progressionplay.setVisibility(View.INVISIBLE);

                } else if (tittle.getText().equals("Ikaw")) {

                    efnotepatern.setTextColor(Color.WHITE);
                    progressionplay.setVisibility(View.GONE);
                    multiplier.setText("A6 X2");
                    ikaw_();
                    setter = 1;

                    play();
                    theads.start();
                    a6();
                    progressionplay.setVisibility(View.INVISIBLE);


                } else if (tittle.getText().equals("Sunshine")) {

                    efnotepatern.setTextColor(Color.WHITE);
                    progressionplay.setVisibility(View.GONE);
                    setter = 1;
                    multiplier.setText("A6 X1");
                    sunshine_();
                    play();
                    theads.start();
                    a6();
                    progressionplay.setVisibility(View.INVISIBLE);

                }
                }

            }
        });

    }


// history of last hit

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

    private void processa3(float pitch2note) {
        pitch2note = (pitch2note / 350) + 10;
        String a = String.format("%.2f", pitch2note);

        if ((pitch2note >= 20.00 && pitch2note < 21.00)) {
            //a7


            efnotepatern.setText("A7");


        }


    }

    // process of pitch to the notes of bars in easy
    public void twinkle() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            twinkle(pitch2note);


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

    public void happybirthday() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            happybirthday(pitch2note);


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

    public void incywincy() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Incywincy(pitch2note);


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

    public void blacksheep() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            babablacksheep(pitch2note);


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

    public void silentnight() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            silent(pitch2note);


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

    public void jinglebell() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            jinglebells(pitch2note);


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


// process of pitch to the notes of bars in normal


    public void ako_ay_may_lobo() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            akoaymaylobo(pitch2note);


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

    public void marry_had_a_little_lamb() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            marryhadalittlelamb(pitch2note);


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

    public void leron_leron_sinta() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            leronleronsinta(pitch2note);


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

    public void one_day() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            oneday(pitch2note);


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

    public void london_bridge() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            londonbridge(pitch2note);


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

    public void mr_bean() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            mrbean(pitch2note);


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


// process of pitch to the notes of bars in hard


    public void days_of_christmas() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            daysofchristmass(pitch2note);


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

    public void isnt_she_lovely() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            isntshelovely(pitch2note);


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

    public void ang_pasko_ay_sumapit() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            angpaskoaysumapit(pitch2note);


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

    public void paro_parong_bukid() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            paroparongbukid(pitch2note);


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

    public void ikaw_() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            ikaw(pitch2note);


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

    public void sunshine_() {

        try {

            AudioDispatcher dispatcher =
                    AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                public void handlePitch(PitchDetectionResult res, AudioEvent e) {


                    final float pitch2note = res.getPitch();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            sunshine(pitch2note);


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


// lyrics of easy ////////////////////////////////////////////

    private void twinkle(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if ((pitch2 >= 32.90 && pitch2 < 33.10) && total == 0) {
            g6();
            total = 1;
            multiplier.setText("G6 X2");
        } else if ((pitch2 >= 34.30 && pitch2 < 34.70) && total == 1) {
            a6();
            total = 2;
            multiplier.setText("A6 X2");

        } else if ((pitch2 >= 35.00 && pitch2 < 35.17) && total == 2) {
            g6();
            total = 3;
            multiplier.setText("G6 X1");

        } else if ((pitch2 >= 34.50 && pitch2 < 34.70) && total == 3) {
            f6();
            total = 4;
            multiplier.setText("F6 X2");

        } else if ((pitch2 >= 34.00 && pitch2 < 34.20) && total == 4) {
            e6();
            total = 5;
            multiplier.setText("E6 X2");

        } else if ((pitch2 >= 33.75 && pitch2 < 33.85) && total == 5) {
            d6();
            total = 6;
            multiplier.setText("D6 X2");

        } else if ((pitch2 >= 33.20 && pitch2 < 33.50) && total == 6) {
            c6();
            total = 7;
            multiplier.setText("C6 X1");

        } else if ((pitch2 >= 32.90 && pitch2 < 33.10) && total == 7) {
            g6();
            total = 8;
            multiplier.setText("G6 X2");

        } else if ((pitch2 >= 34.50 && pitch2 < 34.70) && total == 8) {
            f6();
            total = 9;
            multiplier.setText("F6 X2");

        } else if ((pitch2 >= 34.00 && pitch2 < 34.20) && total == 9) {
            e6();
            total = 10;
            multiplier.setText("E6 X2");

        } else if ((pitch2 >= 33.75 && pitch2 < 34.00) && total == 10) {
            d6();
            total = 11;
            multiplier.setText("D6 X1");

        } else if ((pitch2 >= 33.20 && pitch2 < 33.50) && total == 11) {
            g6();
            total = 12;
            multiplier.setText("G6 X2");

        } else if ((pitch2 >= 34.50 && pitch2 < 34.70) && total == 12) {
            f6();
            total = 13;
            multiplier.setText("F6 X3");

        } else if ((pitch2 >= 34.00 && pitch2 < 34.20) && total == 13) {
            e6();
            total = 14;
            multiplier.setText("E6 X2");

        } else if ((pitch2 >= 33.75 && pitch2 < 33.90) && total == 14) {
            d6();
            total = 15;
            multiplier.setText("D6 X1");


        } else if ((pitch2 >= 33.20 && pitch2 < 33.50) && total == 15) {

            total = 16;
            scoringtwinkletwinke();
        }

    }

    private void happybirthday(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("D6") && total == 0) {
            e6();
            total = 1;
            multiplier.setText("E6 X1");
        } else if (efnotepatern.getText().equals("E6") && total == 1) {
            d6();
            total = 2;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 2) {
            g6();
            total = 3;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 3) {
            fsharp6();
            total = 4;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 4) {
            d6();
            total = 5;
            multiplier.setText("D6 X2");

        } else if (efnotepatern.getText().equals("D6") && total == 5) {
            e6();
            total = 6;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 6) {
            d6();
            total = 7;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 7) {
            a6();
            total = 8;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 8) {
            g6();
            total = 9;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 9) {
            d6();
            total = 10;
            multiplier.setText("D6 X2");

        } else if (efnotepatern.getText().equals("D6") && total == 10) {
            d7();
            total = 11;
            multiplier.setText("D7 X1");

        } else if (efnotepatern.getText().equals("D7") && total == 11) {
            b6();
            total = 12;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 12) {
            g6();
            total = 13;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 13) {
            fsharp6();
            total = 14;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 14) {
            e6();
            total = 15;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 15) {
            c7();
            total = 16;
            multiplier.setText("C7 X2");

        } else if (efnotepatern.getText().equals("C7") && total == 16) {
            b6();
            total = 17;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 17) {
            g6();
            total = 18;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 18) {
            a6();
            total = 19;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 19) {
            g6();
            total = 20;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 20) {
            d6();
            total = 21;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 21) {
            e6();
            total = 22;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 22) {
            d6();
            total = 23;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 23) {
            g6();
            total = 24;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 24) {
            fsharp6();
            total = 25;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 25) {
            d6();
            total = 26;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 26) {
            e6();
            total = 27;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 27) {
            d6();
            total = 28;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 28) {
            a6();
            total = 29;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 29) {
            g6();
            total = 30;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 30) {
            d6();
            total = 31;
            multiplier.setText("D6 X2");

        } else if (efnotepatern.getText().equals("D6") && total == 31) {
            d7();
            total = 32;
            multiplier.setText("D7 X1");

        } else if (efnotepatern.getText().equals("D7") && total == 32) {
            b6();
            total = 33;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 33) {
            g6();
            total = 34;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 34) {
            fsharp6();
            total = 35;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 35) {
            e6();
            total = 36;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 36) {
            c7();
            total = 37;
            multiplier.setText("C7 X2");

        } else if (efnotepatern.getText().equals("C7") && total == 37) {
            b6();
            total = 38;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 38) {
            g6();
            total = 39;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 39) {
            a6();
            total = 40;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 40) {
            g6();
            total = 41;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 41) {
            total = 42;
            scorepophappybirthday();
        }

    }

    private void Incywincy(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("C6") && total == 0) {
            d6();
            total = 1;
            multiplier.setText("D6 X1");
        } else if (efnotepatern.getText().equals("D6") && total == 1) {
            e6();
            total = 2;
            multiplier.setText("E6 X3");

        } else if (efnotepatern.getText().equals("E6") && total == 2) {
            d6();
            total = 3;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 3) {
            c6();
            total = 4;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 4) {
            d6();
            total = 5;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 5) {
            e6();
            total = 6;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 6) {
            c6();
            total = 7;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 7) {
            e6();
            total = 8;
            multiplier.setText("E6 X2");

        } else if (efnotepatern.getText().equals("E6") && total == 8) {
            f6();
            total = 9;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 9) {
            g6();
            total = 10;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 10) {
            f6();
            total = 11;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 11) {
            e6();
            total = 12;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 12) {
            f6();
            total = 13;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 13) {
            g6();
            total = 14;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 14) {
            e6();
            total = 15;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 15) {
            c6();
            total = 16;
            multiplier.setText("C6 X2");

        } else if (efnotepatern.getText().equals("C6") && total == 16) {
            d6();
            total = 17;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 17) {
            e6();
            total = 18;
            multiplier.setText("E6 X2");

        } else if (efnotepatern.getText().equals("E6") && total == 18) {
            d6();
            total = 19;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 19) {
            c6();
            total = 20;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 20) {
            d6();
            total = 21;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 21) {
            e6();
            total = 22;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 22) {
            c6();
            total = 23;
            multiplier.setText("C6 X5");

        } else if (efnotepatern.getText().equals("C6") && total == 23) {
            d6();
            total = 24;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 24) {
            e6();
            total = 25;
            multiplier.setText("E6 X3");

        } else if (efnotepatern.getText().equals("E6") && total == 25) {
            d6();
            total = 26;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 26) {
            c6();
            total = 27;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 27) {
            d6();
            total = 28;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 28) {
            e6();
            total = 29;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 29) {
            c6();
            total = 30;
            multiplier.setText("C6 X1");
        } else if (efnotepatern.getText().equals("C6") && total == 30) {

            total = 31;
            scorepopincywincy();
        }

    }

    private void babablacksheep(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("C6") && total == 0) {
            g6();
            total = 1;
            multiplier.setText("G6 X2");
        } else if (efnotepatern.getText().equals("G6") && total == 1) {
            a6();
            total = 2;
            multiplier.setText("A6 X4");

        } else if (efnotepatern.getText().equals("A6") && total == 2) {
            g6();
            total = 3;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 3) {
            f6();
            total = 4;
            multiplier.setText("F6 X2");

        } else if (efnotepatern.getText().equals("F6") && total == 4) {
            e6();
            total = 5;
            multiplier.setText("E6 X2");

        } else if (efnotepatern.getText().equals("E6") && total == 5) {
            d6();
            total = 6;
            multiplier.setText("D6 X2");

        } else if (efnotepatern.getText().equals("D6") && total == 6) {
            c6();
            total = 7;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 7) {
            g6();
            total = 8;
            multiplier.setText("G6 X3");

        } else if (efnotepatern.getText().equals("G6") && total == 8) {
            f6();
            total = 9;
            multiplier.setText("F6 X2");

        } else if (efnotepatern.getText().equals("F6") && total == 9) {
            e6();
            total = 10;
            multiplier.setText("E6 X3");

        } else if (efnotepatern.getText().equals("E6") && total == 10) {
            d6();
            total = 11;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 11) {
            c6();
            total = 12;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 12) {
            g6();
            total = 13;
            multiplier.setText("G6 X3");

        } else if (efnotepatern.getText().equals("G6") && total == 13) {
            f6();
            total = 14;
            multiplier.setText("F6 X4");

        } else if (efnotepatern.getText().equals("F6") && total == 14) {
            e6();
            total = 15;
            multiplier.setText("E6 X3");

        } else if (efnotepatern.getText().equals("E6") && total == 15) {
            d6();
            total = 16;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 16) {
            total = 17;
            scorepopbabablacksheep();
        }
    }

    private void silent(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("G6") && total == 0) {
            a6();
            total = 1;
            multiplier.setText("A6 X1");
        } else if (efnotepatern.getText().equals("A6") && total == 1) {
            g6();
            total = 2;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 2) {
            e6();
            total = 3;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 3) {
            g6();
            total = 4;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 4) {
            a6();
            total = 5;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 5) {
            g6();
            total = 6;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 6) {
            e6();
            total = 7;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 7) {
            d7();
            total = 8;
            multiplier.setText("D7 X2");

        } else if (efnotepatern.getText().equals("D7") && total == 8) {
            b6();
            total = 9;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 9) {
            c7();
            total = 10;
            multiplier.setText("C7 X2");

        } else if (efnotepatern.getText().equals("C7") && total == 10) {
            g6();
            total = 11;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 11) {
            a6();
            total = 12;
            multiplier.setText("A6 X2");

        } else if (efnotepatern.getText().equals("A6") && total == 12) {
            c7();
            total = 13;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 13) {
            b6();
            total = 14;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 14) {
            a6();
            total = 15;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 15) {
            g6();
            total = 16;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 16) {
            a6();
            total = 17;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 17) {
            g6();
            total = 18;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 18) {
            e6();
            total = 19;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 19) {
            d7();
            total = 20;
            multiplier.setText("D7 X2");

        } else if (efnotepatern.getText().equals("D7") && total == 20) {
            f7();
            total = 21;
            multiplier.setText("F7 X1");

        } else if (efnotepatern.getText().equals("F7") && total == 21) {
            e7();
            total = 22;
            multiplier.setText("E7 X1");

        } else if (efnotepatern.getText().equals("E7") && total == 22) {
            b6();
            total = 23;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 23) {
            c7();
            total = 24;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 24) {
            e7();
            total = 25;
            multiplier.setText("E7 X1");

        } else if (efnotepatern.getText().equals("E7") && total == 25) {
            c7();
            total = 26;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 26) {
            g6();
            total = 27;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 27) {
            e6();
            total = 28;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 28) {
            g6();
            total = 29;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 29) {
            f6();
            total = 30;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 30) {
            d6();
            total = 31;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 31) {
            c6();
            total = 32;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 32) {
            total = 33;
            scorepopsilentnight();
        }
    }

    private void jinglebells(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("B6") && total == 0) {
            d7();
            total = 1;
            multiplier.setText("D7 X1");
        } else if (efnotepatern.getText().equals("D7") && total == 1) {
            g6();
            total = 2;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 2) {
            a6();
            total = 3;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 3) {
            b6();
            total = 4;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 4) {
            c7();
            total = 5;
            multiplier.setText("C7 X4");

        } else if (efnotepatern.getText().equals("C7") && total == 5) {
            b6();
            total = 6;
            multiplier.setText("B6 X3");

        } else if (efnotepatern.getText().equals("B6") && total == 6) {
            a6();
            total = 7;
            multiplier.setText("A6 X2");

        } else if (efnotepatern.getText().equals("A6") && total == 7) {
            b6();
            total = 8;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 8) {
            a6();
            total = 9;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 9) {
            d7();
            total = 10;
            multiplier.setText("D7 X1");

        } else if (efnotepatern.getText().equals("D7") && total == 10) {
            b6();
            total = 11;
            multiplier.setText("B6 X7");

        } else if (efnotepatern.getText().equals("B6") && total == 11) {
            d7();
            total = 12;
            multiplier.setText("D7 X1");

        } else if (efnotepatern.getText().equals("D7") && total == 12) {
            g6();
            total = 13;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 13) {
            a6();
            total = 14;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 14) {
            b6();
            total = 15;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 15) {
            c7();
            total = 16;
            multiplier.setText("C7 X4");

        } else if (efnotepatern.getText().equals("C7") && total == 16) {
            b6();
            total = 17;
            multiplier.setText("B6 X2");

        } else if (efnotepatern.getText().equals("B6") && total == 17) {
            d7();
            total = 18;
            multiplier.setText("D7 X2");

        } else if (efnotepatern.getText().equals("D7") && total == 18) {
            c7();
            total = 19;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 19) {
            a6();
            total = 20;
            multiplier.setText("A6 X1");
        } else if (efnotepatern.getText().equals("A6") && total == 20) {
            g6();
            total = 21;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 21) {

            total = 22;
            scorepopjinglebells();
        }
    }


// lyrics of normal ///////////////////////////////


    private void akoaymaylobo(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("A6") && total == 0) {
            f6();
            total = 1;
            multiplier.setText("F6 X1");
        } else if (efnotepatern.getText().equals("F6") && total == 1) {
            a6();
            total = 2;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 2) {
            g6();
            total = 3;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 3) {
            d6();
            total = 4;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 4) {
            e6();
            total = 5;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 5) {
            f6();
            total = 6;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 6) {
            e6();
            total = 7;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 7) {
            d6();
            total = 8;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 8) {
            c6();
            total = 9;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 9) {
            e6();
            total = 10;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 10) {
            f6();
            total = 11;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 11) {
            g6();
            total = 12;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 12) {
            e6();
            total = 13;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 13) {
            c6();
            total = 14;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 14) {
            e6();
            total = 15;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 15) {
            f6();
            total = 16;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 16) {
            g6();
            total = 17;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 17) {
            f6();
            total = 18;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 18) {
            e6();
            total = 19;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 19) {
            d6();
            total = 20;
            multiplier.setText("D6 X2");

        } else if (efnotepatern.getText().equals("D6") && total == 20) {
            e6();
            total = 21;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 21) {
            f6();
            total = 22;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 22) {
            e6();
            total = 23;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 23) {
            f6();
            total = 24;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 24) {
            d6();
            total = 25;
            multiplier.setText("D6 X2");

        } else if (efnotepatern.getText().equals("D6") && total == 25) {
            e6();
            total = 26;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 26) {
            f6();
            total = 27;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 27) {
            e6();
            total = 28;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 28) {
            d6();
            total = 29;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 29) {
            c6();
            total = 30;
            multiplier.setText("C6 X1");
        } else if (efnotepatern.getText().equals("C6") && total == 30) {
            e6();
            total = 31;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 31) {
            d6();
            total = 32;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 32) {
            c6();
            total = 33;
            multiplier.setText("C6 X2");

        } else if (efnotepatern.getText().equals("C6") && total == 33) {
            d6();
            total = 34;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 34) {
            e6();
            total = 35;
            multiplier.setText("E6 X4");

        } else if (efnotepatern.getText().equals("E6") && total == 35) {
            f6();
            total = 36;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 36) {
            g6();
            total = 37;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 37) {
            a6();
            total = 38;
            multiplier.setText("A6 X4");

        } else if (efnotepatern.getText().equals("A6") && total == 38) {
            f6();
            total = 39;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 39) {
            a6();
            total = 40;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 40) {
            g6();
            total = 41;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 41) {
            d6();
            total = 42;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 42) {
            e6();
            total = 43;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 43) {
            f6();
            total = 44;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 44) {
            e6();
            total = 45;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 45) {
            d6();
            total = 46;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 46) {
            c6();
            total = 47;
            multiplier.setText("C6 X1");


        } else if (efnotepatern.getText().equals("C6") && total == 47) {
            total = 48;
            scorepopakoaymaylobo();
        }

    }

    private void marryhadalittlelamb(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("E6") && total == 0) {
            d6();
            total = 1;
            multiplier.setText("D6 X1");
        } else if (efnotepatern.getText().equals("D6") && total == 1) {
            c6();
            total = 2;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 2) {
            d6();
            total = 3;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 3) {
            e6();
            total = 4;
            multiplier.setText("E6 X3");

        } else if (efnotepatern.getText().equals("E6") && total == 4) {
            d6();
            total = 5;
            multiplier.setText("D6 X3");

        } else if (efnotepatern.getText().equals("D6") && total == 5) {
            e6();
            total = 6;
            multiplier.setText("E6 X4");

        } else if (efnotepatern.getText().equals("E6") && total == 6) {
            d6();
            total = 7;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 7) {
            c6();
            total = 8;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 8) {
            d6();
            total = 9;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 9) {
            e6();
            total = 10;
            multiplier.setText("E6 X4");

        } else if (efnotepatern.getText().equals("E6") && total == 10) {
            d6();
            total = 11;
            multiplier.setText("D6 X2");

        } else if (efnotepatern.getText().equals("D6") && total == 11) {
            e6();
            total = 12;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 12) {
            d6();
            total = 13;
            multiplier.setText("D6 X1");
//////////////////////////////////////////////////////////////////////////////////////////

        } else if (efnotepatern.getText().equals("D6") && total == 13) {
            c6();
            total = 14;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 14) {
            total = 15;
            scorepopmaryhadalittlelamb();
        }
    }

    private void leronleronsinta(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("G6") && total == 0) {
            f6();
            total = 1;
            multiplier.setText("F6 X1");
        } else if (efnotepatern.getText().equals("F6") && total == 1) {
            e6();
            total = 2;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 2) {
            f6();
            total = 3;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 3) {
            g6();
            total = 4;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 4) {
            a6();
            total = 5;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 5) {
            g6();
            total = 6;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 6) {
            e6();
            total = 7;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 7) {
            g6();
            total = 8;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 8) {
            f6();
            total = 9;
            multiplier.setText("F6 X3");

        } else if (efnotepatern.getText().equals("F6") && total == 9) {
            e6();
            total = 10;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 10) {
            d6();
            total = 11;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 11) {
            e6();
            total = 12;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 12) {
            f6();
            total = 13;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 13) {
            g6();
            total = 14;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 14) {
            a6();
            total = 15;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 15) {
            g6();
            total = 16;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 16) {
            f6();
            total = 17;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 17) {
            e6();
            total = 18;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 18) {
            g6();
            total = 19;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 19) {
            f6();
            total = 20;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 20) {
            e6();
            total = 21;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 21) {
            f6();
            total = 22;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 22) {
            g6();
            total = 23;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 23) {
            c6();
            total = 24;
            multiplier.setText("C6 X3");

        } else if (efnotepatern.getText().equals("C6") && total == 24) {
            f6();
            total = 25;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 25) {
            g6();
            total = 26;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 26) {
            a6();
            total = 27;
            multiplier.setText("A6 X3");

        } else if (efnotepatern.getText().equals("A6") && total == 27) {
            c7();
            total = 28;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 28) {
            b6();
            total = 29;
            multiplier.setText("B7 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 29) {
            a6();
            total = 30;
            multiplier.setText("A6 X1");
        } else if (efnotepatern.getText().equals("A6") && total == 30) {
            g6();
            total = 31;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 31) {
            f6();
            total = 32;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 32) {
            a6();
            total = 33;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 33) {
            g6();
            total = 34;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 34) {
            f6();
            total = 35;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 35) {
            e6();
            total = 36;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 36) {
            total = 37;
            scorepopleronleronsinta();
        }
    }

    private void oneday(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("C6") && total == 0) {
            e6();
            total = 1;
            multiplier.setText("E6 X1");
        } else if (efnotepatern.getText().equals("E6") && total == 1) {
            g6();
            total = 2;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 2) {
            a6();
            total = 3;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 3) {
            g6();
            total = 4;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 4) {
            e6();
            total = 5;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 5) {
            g6();
            total = 6;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 6) {
            a6();
            total = 7;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 7) {
            g6();
            total = 8;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 8) {
            e6();
            total = 9;
            multiplier.setText("E6 X2");

        } else if (efnotepatern.getText().equals("E6") && total == 9) {
            g6();
            total = 10;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 10) {
            f6();
            total = 11;
            multiplier.setText("F6 X2");

        } else if (efnotepatern.getText().equals("F6") && total == 11) {
            e6();
            total = 12;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 12) {
            d6();
            total = 13;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 13) {
            c6();
            total = 14;
            multiplier.setText("C6 X3");

        } else if (efnotepatern.getText().equals("C6") && total == 14) {
            e6();
            total = 15;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 15) {
            g6();
            total = 16;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 16) {
            a6();
            total = 17;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 17) {
            g6();
            total = 18;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 18) {
            e6();
            total = 19;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 19) {
            g6();
            total = 20;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 20) {
            a6();
            total = 21;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 21) {
            g6();
            total = 22;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 22) {
            e6();
            total = 23;
            multiplier.setText("E6 X2");

        } else if (efnotepatern.getText().equals("E6") && total == 23) {
            g6();
            total = 24;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 24) {
            f6();
            total = 25;
            multiplier.setText("F6 X2");

        } else if (efnotepatern.getText().equals("F6") && total == 25) {
            e6();
            total = 26;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 26) {
            d6();
            total = 27;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 27) {
            c6();
            total = 28;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 28) {
            e6();
            total = 29;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 29) {
            g6();
            total = 30;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 30) {
            d6();
            total = 31;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 31) {
            g6();
            total = 32;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 32) {
            c6();
            total = 33;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 33) {
            f6();
            total = 34;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 34) {
            e6();
            total = 35;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 35) {
            d6();
            total = 36;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 36) {
            c6();
            total = 37;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 37) {
            e6();
            total = 38;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 38) {
            g6();
            total = 39;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 39) {
            d6();
            total = 40;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 40) {
            g6();
            total = 41;
            multiplier.setText("E6 X2");

        } else if (efnotepatern.getText().equals("E6") && total == 41) {
            c6();
            total = 42;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 42) {
            f6();
            total = 43;
            multiplier.setText("F6 X2");

        } else if (efnotepatern.getText().equals("F6") && total == 43) {
            e6();
            total = 44;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 44) {
            d6();
            total = 45;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 45) {
            c6();
            total = 46;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 46) {
            total = 47;
            scorepoponeday();
        }
    }

    private void londonbridge(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("G6") && total == 0) {
            a6();
            total = 1;
            multiplier.setText("A6 X1");
        } else if (efnotepatern.getText().equals("A6") && total == 1) {
            g6();
            total = 2;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 2) {
            f6();
            total = 3;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 3) {
            e6();
            total = 4;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 4) {
            f6();
            total = 5;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 5) {
            g6();
            total = 6;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 6) {
            d6();
            total = 7;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 7) {
            e6();
            total = 8;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 8) {
            f6();
            total = 9;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 9) {
            e6();
            total = 10;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 10) {
            f6();
            total = 11;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 11) {
            g6();
            total = 12;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 12) {
            a6();
            total = 13;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 13) {
            g6();
            total = 14;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 14) {
            f6();
            total = 15;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 15) {
            e6();
            total = 16;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 16) {
            f6();
            total = 17;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 17) {
            g6();
            total = 18;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 18) {
            d6();
            total = 19;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 19) {
            g6();
            total = 20;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 20) {
            e6();
            total = 21;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 21) {
            c6();
            total = 22;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 22) {
            g6();
            total = 23;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 23) {
            a6();
            total = 24;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 24) {
            g6();
            total = 25;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 25) {
            f6();
            total = 26;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 26) {
            e6();
            total = 27;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 27) {
            f6();
            total = 28;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 28) {
            g6();
            total = 29;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 29) {
            d6();
            total = 30;
            multiplier.setText("D6 X1");
        } else if (efnotepatern.getText().equals("D6") && total == 30) {
            e6();
            total = 31;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 31) {
            f6();
            total = 32;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 32) {
            e6();
            total = 33;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 33) {
            f6();
            total = 34;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 34) {
            g6();
            total = 35;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 35) {
            a6();
            total = 36;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 36) {
            g6();
            total = 37;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 37) {
            f6();
            total = 38;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 38) {
            e6();
            total = 39;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 39) {
            f6();
            total = 40;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 40) {
            g6();
            total = 41;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 41) {
            d6();
            total = 42;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 42) {
            g6();
            total = 43;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 43) {
            e6();
            total = 44;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 44) {
            c6();
            total = 45;
            multiplier.setText("C6 X1");


        } else if (efnotepatern.getText().equals("C6") && total == 45) {
            total = 46;
            scorepoplondonbridge();

        }

    }

    private void mrbean(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("A5") && total == 0) {
            c6();
            total = 1;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 1) {
            d6();
            total = 2;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 2) {
            e6();
            total = 3;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 3) {
            a6();
            total = 4;
            multiplier.setText("A6 X2");

        } else if (efnotepatern.getText().equals("A6") && total == 4) {
            g6();
            total = 5;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 5) {
            e6();
            total = 6;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 6) {
            d6();
            total = 7;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 7) {
            c6();
            total = 8;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 8) {
            a5();
            total = 9;
            multiplier.setText("A5 X1");

        } else if (efnotepatern.getText().equals("A5") && total == 9) {
            c6();
            total = 10;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 10) {
            d6();
            total = 11;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 11) {
            e6();
            total = 12;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 12) {
            a6();
            total = 13;
            multiplier.setText("A6 X2");

        } else if (efnotepatern.getText().equals("A6") && total == 13) {
            g6();
            total = 14;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 14) {
            a5();
            total = 15;
            multiplier.setText("A5 X1");

        } else if (efnotepatern.getText().equals("A5") && total == 15) {
            b5();
            total = 16;
            multiplier.setText("B5 X1");

        } else if (efnotepatern.getText().equals("B5") && total == 16) {
            a5();
            total = 17;
            multiplier.setText("A5 X2");

        } else if (efnotepatern.getText().equals("A5") && total == 17) {
            c6();
            total = 18;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 18) {
            d6();
            total = 19;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 19) {
            e6();
            total = 20;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 20) {
            a6();
            total = 21;
            multiplier.setText("A6 X2");

        } else if (efnotepatern.getText().equals("A6") && total == 21) {
            g6();
            total = 22;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 22) {
            e6();
            total = 23;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 23) {
            d6();
            total = 24;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 24) {
            c6();
            total = 25;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 25) {
            a5();
            total = 26;
            multiplier.setText("A5 X1");

        } else if (efnotepatern.getText().equals("A5") && total == 26) {
            c6();
            total = 27;
            multiplier.setText("C6 X2");

        } else if (efnotepatern.getText().equals("C6") && total == 27) {
            a5();
            total = 28;
            multiplier.setText("A5 X1");

        } else if (efnotepatern.getText().equals("A5") && total == 28) {
            c6();
            total = 29;
            multiplier.setText("C6 X1");
        } else if (efnotepatern.getText().equals("C6") && total == 29) {
            a5();
            total = 30;
            multiplier.setText("A5 X3");

        } else if (efnotepatern.getText().equals("A5") && total == 30) {
            b5();
            total = 31;
            multiplier.setText("B5 X1");

        } else if (efnotepatern.getText().equals("B5") && total == 31) {
            c6();
            total = 32;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 32) {

            total = 33;
            scorepopmrbean();
        }


    }


    // lyrics of hard ///////////////////


    private void daysofchristmass(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("B6") && total == 0) {
            e6();
            total = 1;
            multiplier.setText("E6 X5");
        } else if (efnotepatern.getText().equals("E6") && total == 1) {
            fsharp6();
            total = 2;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 2) {
            gsharp6();
            total = 3;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 3) {
            a6();
            total = 4;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 4) {
            fsharp6();
            total = 5;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 5) {
            gsharp6();
            total = 6;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 6) {
            a6();
            total = 7;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 7) {
            b6();
            total = 8;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 8) {
            c7();
            total = 9;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 9) {
            a6();
            total = 10;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 10) {
            gsharp6();
            total = 11;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 11) {
            e6();
            total = 12;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 12) {
            fsharp6();
            total = 13;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 13) {
            e6();
            total = 14;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 14) {
            b6();
            total = 15;
            multiplier.setText("B6 X4");

        } else if (efnotepatern.getText().equals("B6") && total == 15) {
            e6();
            total = 16;
            multiplier.setText("E6 X5");

        } else if (efnotepatern.getText().equals("E6") && total == 16) {
            fsharp6();
            total = 17;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 17) {
            gsharp6();
            total = 18;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 18) {
            a6();
            total = 19;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 19) {
            fsharp6();
            total = 20;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 20) {
            gsharp6();
            total = 21;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 21) {
            b6();
            total = 22;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 22) {
            fsharp6();
            total = 23;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 23) {
            gsharp6();
            total = 24;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 24) {
            a6();
            total = 25;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 25) {
            gsharp6();
            total = 26;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 26) {
            a6();
            total = 27;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 27) {
            b6();
            total = 28;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 28) {
            csharp7();
            total = 29;
            multiplier.setText("C#7 X1");

        } else if (efnotepatern.getText().equals("C#7") && total == 29) {
            a6();
            total = 30;
            multiplier.setText("A6 X1");
        } else if (efnotepatern.getText().equals("A6") && total == 30) {
            gsharp6();
            total = 31;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 31) {
            e6();
            total = 32;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 32) {
            fsharp6();
            total = 33;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 33) {
            e6();
            total = 34;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 34) {
            b6();
            total = 35;
            multiplier.setText("B6 X3");

        } else if (efnotepatern.getText().equals("B6") && total == 35) {
            e6();
            total = 36;
            multiplier.setText("E6 X5");

        } else if (efnotepatern.getText().equals("E6") && total == 36) {
            fsharp6();
            total = 37;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 37) {
            gsharp6();
            total = 38;
            multiplier.setText("G#6 X1 ");

        } else if (efnotepatern.getText().equals("G#6") && total == 38) {
            a6();
            total = 39;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 39) {
            fsharp6();
            total = 40;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 40) {
            gsharp6();
            total = 41;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 41) {
            b6();
            total = 42;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 42) {
            fsharp6();
            total = 43;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 43) {
            gsharp6();
            total = 44;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 44) {
            a6();
            total = 45;
            multiplier.setText("A6 X1");


        } else if (efnotepatern.getText().equals("A6") && total == 45) {
            b6();
            total = 46;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 46) {
            fsharp6();
            total = 47;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 47) {
            gsharp6();
            total = 48;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 48) {
            a6();
            total = 49;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 49) {
            fsharp6();
            total = 50;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 50) {
            a6();
            total = 51;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 51) {
            b6();
            total = 52;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 52) {
            csharp7();
            total = 53;
            multiplier.setText("C#7 X1");

        } else if (efnotepatern.getText().equals("C#7") && total == 53) {
            a6();
            total = 54;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 54) {
            gsharp6();
            total = 55;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 55) {
            e6();
            total = 56;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 56) {
            fsharp6();
            total = 57;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 57) {
            e6();
            total = 58;
            multiplier.setText("E6 X1");
        } else if (efnotepatern.getText().equals("E6") && total == 58) {
            b6();
            total = 59;
            multiplier.setText("B6 X3");

        } else if (efnotepatern.getText().equals("B6") && total == 59) {
            e6();
            total = 60;
            multiplier.setText("E6 X5");

        } else if (efnotepatern.getText().equals("E6") && total == 60) {
            fsharp6();
            total = 61;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 61) {
            gsharp6();
            total = 62;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 62) {
            a6();
            total = 63;
            multiplier.setText("A6 X1");


        } else if (efnotepatern.getText().equals("A6") && total == 63) {
            fsharp6();
            total = 64;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 64) {
            gsharp6();
            total = 65;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 65) {
            b6();
            total = 66;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 66) {
            fsharp6();
            total = 67;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 67) {
            g6();
            total = 68;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 68) {
            a6();
            total = 69;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 69) {
            b6();
            total = 70;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 70) {
            fsharp6();
            total = 71;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 71) {
            gsharp6();
            total = 72;
            multiplier.setText("G#6 X1");


        } else if (efnotepatern.getText().equals("G#6") && total == 72) {
            a6();
            total = 73;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 73) {
            b6();
            total = 74;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 74) {
            f6();
            total = 75;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 75) {
            gsharp6();
            total = 76;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 76) {
            a6();
            total = 77;
            multiplier.setText("A6 X1");


        } else if (efnotepatern.getText().equals("A6") && total == 77) {
            gsharp6();
            total = 78;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 78) {
            a6();
            total = 79;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 79) {
            b6();
            total = 80;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 80) {
            csharp7();
            total = 81;
            multiplier.setText("C#7 X1");

        } else if (efnotepatern.getText().equals("C#7") && total == 81) {
            b6();
            total = 82;
            multiplier.setText("A6 X1");


        } else if (efnotepatern.getText().equals("A6") && total == 82) {
            gsharp6();
            total = 83;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 83) {
            e6();
            total = 84;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 84) {
            fsharp6();
            total = 85;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 85) {
            e6();
            total = 86;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 86) {
            total = 87;
            scoringdaysofchristmas();
        }
    }

    private void isntshelovely(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("G#6") && total == 0) {
            a6();
            total = 1;
            multiplier.setText("A6 X1");
        } else if (efnotepatern.getText().equals("A6") && total == 1) {
            gsharp6();
            total = 2;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 2) {
            fsharp6();
            total = 3;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 3) {
            e6();
            total = 4;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 4) {
            gsharp6();
            total = 5;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 5) {
            a6();
            total = 6;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 6) {
            gsharp6();
            total = 7;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 7) {
            fsharp6();
            total = 8;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 8) {
            e6();
            total = 9;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 9) {
            b6();
            total = 10;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 10) {
            gsharp6();
            total = 11;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 11) {
            a6();
            total = 12;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 12) {
            b6();
            total = 13;
            multiplier.setText("B6 X2");

        } else if (efnotepatern.getText().equals("B6") && total == 13) {
            gsharp6();
            total = 14;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 14) {
            a6();
            total = 15;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 15) {
            b6();
            total = 16;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 16) {
            a6();
            total = 17;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 17) {
            gsharp6();
            total = 18;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 18) {
            fsharp6();
            total = 19;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 19) {
            e6();
            total = 20;
            multiplier.setText("E6 X3");

        } else if (efnotepatern.getText().equals("E6") && total == 20) {
            fsharp6();
            total = 21;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 21) {
            csharp6();
            total = 22;
            multiplier.setText("C#6 X2");

        } else if (efnotepatern.getText().equals("C#6") && total == 22) {
            gsharp7();
            total = 23;
            multiplier.setText("G#7 X1");

        } else if (efnotepatern.getText().equals("G#7") && total == 23) {
            a7();
            total = 24;
            multiplier.setText("A7 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 24) {
            gsharp7();
            total = 25;
            multiplier.setText("G#7 X1");

        } else if (efnotepatern.getText().equals("G#7") && total == 25) {
            fsharp7();
            total = 26;
            multiplier.setText("F#7 X1");

        } else if (efnotepatern.getText().equals("F#7") && total == 26) {
            e7();
            total = 27;
            multiplier.setText("E7 X1");

        } else if (efnotepatern.getText().equals("E7") && total == 27) {
            csharp7();
            total = 28;
            multiplier.setText("C#7 X1");

        } else if (efnotepatern.getText().equals("C#7") && total == 28) {
            b6();
            total = 29;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 29) {
            e6();
            total = 30;
            multiplier.setText("E6 X1");
        } else if (efnotepatern.getText().equals("E6") && total == 30) {
            total = 31;
            scoringisntshelovely();


        }
    }

    private void angpaskoaysumapit(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("C6") && total == 0) {
            d6();
            total = 1;
            multiplier.setText("D6 X1");
        } else if (efnotepatern.getText().equals("D6") && total == 1) {
            dsharp6();
            total = 2;
            multiplier.setText("D#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 2) {
            g6();
            total = 3;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 3) {
            d6();
            total = 4;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 4) {
            asharp6();
            total = 5;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 5) {
            c6();
            total = 6;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 6) {
            d6();
            total = 7;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 7) {
            dsharp6();
            total = 8;
            multiplier.setText("D#6 X1");

        } else if (efnotepatern.getText().equals("D#6") && total == 8) {
            d6();
            total = 9;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 9) {
            c6();
            total = 10;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 10) {
            d6();
            total = 11;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 11) {
            asharp6();
            total = 12;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 12) {
            a6();
            total = 13;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 13) {
            g6();
            total = 14;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 14) {
            d6();
            total = 15;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 15) {
            dsharp6();
            total = 16;
            multiplier.setText("D#6 X1");

        } else if (efnotepatern.getText().equals("D#6") && total == 16) {
            d6();
            total = 17;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 17) {
            c6();
            total = 18;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 18) {
            d6();
            total = 19;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 19) {
            asharp6();
            total = 20;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 20) {
            g6();
            total = 21;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 21) {
            asharp6();
            total = 22;
            multiplier.setText("A#6 X4");

        } else if (efnotepatern.getText().equals("A#6") && total == 22) {
            c7();
            total = 23;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 23) {
            asharp6();
            total = 24;
            multiplier.setText("A#6 X2");

        } else if (efnotepatern.getText().equals("A#6") && total == 24) {
            a6();
            total = 25;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 25) {
            d6();
            total = 26;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 26) {
            dsharp7();
            total = 27;
            multiplier.setText("D#6 X1");

        } else if (efnotepatern.getText().equals("D#6") && total == 27) {
            d6();
            total = 28;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 28) {
            c6();
            total = 29;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 29) {
            d6();
            total = 30;
            multiplier.setText("D6 X1");
        } else if (efnotepatern.getText().equals("D6") && total == 30) {
            a6();
            total = 31;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 31) {
            fsharp6();
            total = 32;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 32) {
            a6();
            total = 33;
            multiplier.setText("A6 X5");

        } else if (efnotepatern.getText().equals("A6") && total == 33) {
            asharp6();
            total = 34;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 34) {
            a6();
            total = 35;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 35) {
            g6();
            total = 36;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 36) {
            d6();
            total = 37;
            multiplier.setText("D6 X2");

        } else if (efnotepatern.getText().equals("D6") && total == 37) {
            dsharp6();
            total = 38;
            multiplier.setText("D#6 X1");

        } else if (efnotepatern.getText().equals("D#6") && total == 38) {
            d6();
            total = 39;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 39) {
            c6();
            total = 40;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 40) {
            d6();
            total = 41;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 41) {
            asharp6();
            total = 42;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 42) {
            g6();
            total = 43;
            multiplier.setText("G6 X5");

        } else if (efnotepatern.getText().equals("G6") && total == 43) {
            gsharp6();
            total = 44;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 44) {
            g6();
            total = 45;
            multiplier.setText("G6 X1");


        } else if (efnotepatern.getText().equals("G6") && total == 45) {
            f6();
            total = 46;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 46) {
            dsharp6();
            total = 47;
            multiplier.setText("D#6 X2");

        } else if (efnotepatern.getText().equals("D#6") && total == 47) {
            c6();
            total = 48;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 48) {
            d6();
            total = 49;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 49) {
            dsharp6();
            total = 50;
            multiplier.setText("D#6 X1");

        } else if (efnotepatern.getText().equals("D#6") && total == 50) {
            g6();
            total = 51;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 51) {
            d6();
            total = 52;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 52) {
            asharp5();
            total = 53;
            multiplier.setText("A#5 X1");

        } else if (efnotepatern.getText().equals("A#5") && total == 53) {
            c6();
            total = 54;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 54) {
            d6();
            total = 55;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 55) {
            dsharp6();
            total = 56;
            multiplier.setText("D#6 X1");

        } else if (efnotepatern.getText().equals("D#6") && total == 56) {
            d6();
            total = 57;
            multiplier.setText("D6 X3");

        } else if (efnotepatern.getText().equals("D6") && total == 57) {
            asharp6();
            total = 58;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 58) {
            a6();
            total = 59;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 59) {
            g6();
            total = 60;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 60) {
            total = 61;
            scoringangpaskoaysumapit();

        }
    }

    private void paroparongbukid(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("D6") && total == 0) {
            e6();
            total = 1;
            multiplier.setText("E6 X1");
        } else if (efnotepatern.getText().equals("E6") && total == 1) {
            d6();
            total = 2;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 2) {
            g6();
            total = 3;
            multiplier.setText("G6 X3");

        } else if (efnotepatern.getText().equals("G6") && total == 3) {
            fsharp6();
            total = 4;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 4) {
            g6();
            total = 5;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 5) {
            a6();
            total = 6;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 6) {
            d6();
            total = 7;
            multiplier.setText("D6 X4");

        } else if (efnotepatern.getText().equals("D6") && total == 7) {
            e6();
            total = 8;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 8) {
            d6();
            total = 9;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 9) {
            a6();
            total = 10;
            multiplier.setText("A6 X3");

        } else if (efnotepatern.getText().equals("A6") && total == 10) {
            g6();
            total = 11;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 11) {
            a6();
            total = 12;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 12) {
            b6();

            total = 13;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 13) {
            d6();
            total = 14;
            multiplier.setText("D6 X5");

        } else if (efnotepatern.getText().equals("D6") && total == 14) {
            e6();
            total = 15;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 15) {
            d6();
            total = 16;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 16) {
            g6();
            total = 17;
            multiplier.setText("G6 X3");

        } else if (efnotepatern.getText().equals("G6") && total == 17) {
            fsharp6();
            total = 18;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 18) {
            g6();
            total = 19;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 19) {
            e6();
            total = 20;
            multiplier.setText("E6 X2");

        } else if (efnotepatern.getText().equals("E6") && total == 20) {
            fsharp6();
            total = 21;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 21) {
            g6();
            total = 22;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 22) {
            a6();
            total = 23;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 23) {
            b6();
            total = 24;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 24) {
            d6();
            total = 25;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 25) {
            g6();
            total = 26;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 26) {
            fsharp6();
            total = 27;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 27) {
            e6();
            total = 28;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 28) {
            fsharp6();
            total = 29;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 29) {
            g6();
            total = 30;
            multiplier.setText("G6 X4");
        } else if (efnotepatern.getText().equals("G6") && total == 30) {
            total = 31;
            scoringparuparongbukid();
        }
    }

    private void ikaw(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("A6") && total == 0) {
            asharp6();
            total = 1;
            multiplier.setText("A#6 X1");
        } else if (efnotepatern.getText().equals("A#6") && total == 1) {
            c7();
            total = 2;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 2) {
            a6();
            total = 3;
            multiplier.setText("A6 X2");

        } else if (efnotepatern.getText().equals("A6") && total == 3) {
            asharp6();
            total = 4;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 4) {
            g7();
            total = 5;
            multiplier.setText("G7 X1");

        } else if (efnotepatern.getText().equals("G7") && total == 5) {
            f7();
            total = 6;
            multiplier.setText("F7 X1");

        } else if (efnotepatern.getText().equals("F7") && total == 6) {
            a6();
            total = 7;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 7) {
            asharp6();
            total = 8;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 8) {
            g6();
            total = 9;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 9) {
            a6();
            total = 10;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 10) {
            asharp6();
            total = 11;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 11) {
            f7();
            total = 12;
            multiplier.setText("F7 X1");

        } else if (efnotepatern.getText().equals("F7") && total == 12) {
            e7();
            total = 13;
            multiplier.setText("E7 X1");

        } else if (efnotepatern.getText().equals("E7") && total == 13) {
            g6();
            total = 14;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 14) {
            a6();
            total = 15;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 15) {
            f6();
            total = 16;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 16) {
            g6();
            total = 17;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 17) {
            a6();
            total = 18;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 18) {
            e7();
            total = 19;
            multiplier.setText("E7 X1");

        } else if (efnotepatern.getText().equals("E7") && total == 19) {
            d7();
            total = 20;
            multiplier.setText("D7 X1");

        } else if (efnotepatern.getText().equals("D7") && total == 20) {
            f6();
            total = 21;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 21) {
            g6();
            total = 22;
            multiplier.setText("G6 X4");

        } else if (efnotepatern.getText().equals("G6") && total == 22) {
            a6();
            total = 23;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 23) {
            asharp6();
            total = 24;
            multiplier.setText("A#6 X2");

        } else if (efnotepatern.getText().equals("A#6") && total == 24) {
            c7();
            total = 25;
            multiplier.setText("C7 X2");

        } else if (efnotepatern.getText().equals("C7") && total == 25) {
            a6();
            total = 26;
            multiplier.setText("A6 X2");

        } else if (efnotepatern.getText().equals("A6") && total == 26) {
            asharp6();
            total = 27;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 27) {
            g7();
            total = 28;
            multiplier.setText("G7 X1");

        } else if (efnotepatern.getText().equals("G7") && total == 28) {
            f7();
            total = 29;
            multiplier.setText("F7 X1");

        } else if (efnotepatern.getText().equals("F7") && total == 29) {
            a6();
            total = 30;
            multiplier.setText("A6 X1");
        } else if (efnotepatern.getText().equals("A6") && total == 30) {
            asharp6();
            total = 31;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 31) {
            g6();
            total = 32;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 32) {
            a6();
            total = 33;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 33) {
            asharp6();
            total = 34;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 34) {
            f7();
            total = 35;
            multiplier.setText("F7 X1");

        } else if (efnotepatern.getText().equals("F7") && total == 35) {
            e7();
            total = 36;
            multiplier.setText("E7 X1");

        } else if (efnotepatern.getText().equals("E7") && total == 36) {
            g6();
            total = 37;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 37) {
            a6();
            total = 38;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 38) {
            f6();
            total = 39;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 39) {
            g6();
            total = 40;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 40) {
            a6();
            total = 41;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 41) {
            e7();
            total = 42;
            multiplier.setText("E7 X1");

        } else if (efnotepatern.getText().equals("E7") && total == 42) {
            d7();
            total = 43;
            multiplier.setText("D7 X1");


        } else if (efnotepatern.getText().equals("D7") && total == 43) {
            f6();
            total = 44;
            multiplier.setText("F6 X1");


        } else if (efnotepatern.getText().equals("F6") && total == 44) {
            g6();
            total = 45;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 45) {
            a6();
            total = 46;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 46) {
            asharp6();
            total = 47;
            multiplier.setText("A#7 X1");

        } else if (efnotepatern.getText().equals("A#7") && total == 47) {
            c7();
            total = 48;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 48) {
            g6();
            total = 49;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 49) {
            a6();
            total = 50;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 50) {
            g6();
            total = 51;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 51) {
            a6();
            total = 52;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 52) {
            asharp6();
            total = 53;
            multiplier.setText("A#6 X2");

        } else if (efnotepatern.getText().equals("A#6") && total == 53) {
            a6();
            total = 54;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 54) {
            g6();
            total = 55;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 55) {
            f6();
            total = 56;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 56) {
            g6();
            total = 57;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 57) {
            a6();
            total = 58;
            multiplier.setText("A6 X2");

        } else if (efnotepatern.getText().equals("A6") && total == 58) {
            g6();
            total = 59;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 59) {
            f6();
            total = 60;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 60) {
            e6();
            total = 61;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 61) {
            f6();
            total = 62;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 62) {
            d6();
            total = 63;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 63) {
            f6();
            total = 64;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 64) {
            d6();
            total = 65;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 65) {
            f6();
            total = 66;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 66) {
            d6();
            total = 67;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 67) {
            f6();
            total = 68;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 68) {
            d6();
            total = 69;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 69) {
            f6();
            total = 70;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 70) {
            d6();
            total = 71;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 71) {
            f6();
            total = 72;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 72) {
            g6();
            total = 73;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 73) {
            a6();
            total = 74;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 74) {
            g6();
            total = 75;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 75) {
            f7();
            total = 76;
            multiplier.setText("F7 X1");

        } else if (efnotepatern.getText().equals("F7") && total == 76) {
            c7();
            total = 77;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 77) {
            a6();
            total = 78;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 78) {
            g6();
            total = 79;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 79) {
            a6();
            total = 80;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 80) {
            asharp6();
            total = 81;
            multiplier.setText("A#6 X2");

        } else if (efnotepatern.getText().equals("A#6") && total == 81) {
            a6();
            total = 82;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 82) {
            g6();
            total = 83;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 83) {
            f6();
            total = 84;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 84) {
            g6();
            total = 85;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 85) {
            a6();
            total = 86;
            multiplier.setText("A6 X2");

        } else if (efnotepatern.getText().equals("A6") && total == 86) {
            g6();
            total = 87;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 87) {
            f6();
            total = 88;
            multiplier.setText("F6 X1");


        } else if (efnotepatern.getText().equals("F6") && total == 88) {
            e6();
            total = 89;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 89) {
            f6();
            total = 90;
            multiplier.setText("F6 X1");
        } else if (efnotepatern.getText().equals("F6") && total == 90) {
            d6();
            total = 91;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 91) {
            f6();
            total = 92;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 92) {
            d6();
            total = 93;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 93) {
            f6();
            total = 94;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 94) {
            d6();
            total = 95;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 95) {
            f6();
            total = 96;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 96) {
            d6();
            total = 97;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 97) {
            f6();
            total = 98;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 98) {
            d6();
            total = 99;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 99) {
            f6();
            total = 100;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 100) {
            g6();
            total = 101;
            multiplier.setText("G6 X2");

        } else if (efnotepatern.getText().equals("G6") && total == 101) {
            a6();
            total = 102;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 102) {
            g6();
            total = 103;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 103) {
            f6();
            total = 104;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 104) {
            e6();
            total = 105;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 105) {
            f6();
            total = 106;
            multiplier.setText("F6 X1");
        } else if (efnotepatern.getText().equals("F6") && total == 106)
        {           total = 107;
        scoringikaw();


    }

}



    private void sunshine(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("A6") && total == 0) {
            d6();
            total = 1;
            multiplier.setText("D6 X1");
        } else if (efnotepatern.getText().equals("D6") && total == 1) {
            e6();
            total = 2;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 2) {
            fsharp6();
            total = 3;
            multiplier.setText("F#6 X3");

        } else if (efnotepatern.getText().equals("F#6") && total == 3) {
            e6();
            total = 4;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 4) {
            fsharp6();
            total = 5;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 5) {
            d6();
            total = 6;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 6) {
            a5();
            total = 7;
            multiplier.setText("A5 X1");

        } else if (efnotepatern.getText().equals("A5") && total == 7) {
            d6();
            total = 8;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 8) {
            e6();
            total = 9;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 9) {
            fsharp6();
            total = 10;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 10) {
            g6();
            total = 11;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 11) {
            b6();
            total = 12;
            multiplier.setText("B6 X2");

        } else if (efnotepatern.getText().equals("B6") && total == 12) {
            a6();
            total = 13;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 13) {
            g6();
            total = 14;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 14) {
            fsharp6();
            total = 15;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 15) {
            d6();
            total = 16;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 16) {
            e6();
            total = 17;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 17) {
            fsharp6();
            total = 18;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 18) {
            g6();
            total = 19;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 19) {
            b6();
            total = 20;
            multiplier.setText("B6 X2");

        } else if (efnotepatern.getText().equals("B6") && total == 20) {
            a6();
            total = 21;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 21) {
            g6();
            total = 22;
            multiplier.setText("G6 X4");

        } else if (efnotepatern.getText().equals("G6") && total == 22) {
            fsharp6();
            total = 23;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 23) {
            d6();
            total = 24;
            multiplier.setText("D6 X2");

        } else if (efnotepatern.getText().equals("D6") && total == 24) {
            e6();
            total = 25;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 25) {
            fsharp6();
            total = 26;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 26) {
            g6();
            total = 27;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 27) {
            e6();
            total = 28;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 28) {
            a6();
            total = 29;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 29) {
            d6();
            total = 30;
            multiplier.setText("D6 X1");
        }
        else if (efnotepatern.getText().equals("D6") && total == 30) {
            a6();
            total = 31;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 31) {
            d6();
            total = 32;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 32) {
            e6();
            total = 33;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 33) {
            fsharp6();
            total = 34;
            multiplier.setText("F#6 X3");

        } else if (efnotepatern.getText().equals("F#6") && total == 34) {
            e6();
            total = 35;
            multiplier.setText("E6 X2");

        } else if (efnotepatern.getText().equals("E6") && total == 35) {
            fsharp6();
            total = 36;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 36) {
            d6();
            total = 37;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 37) {
            a6();
            total = 38;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 38) {
            d6();
            total = 39;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 39) {
            e6();
            total = 40;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 40) {
            fsharp6();
            total = 41;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 41) {
            g6();
            total = 42;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 42) {
            b6();
            total = 43;
            multiplier.setText("B6 X2");

        } else if (efnotepatern.getText().equals("B6") && total == 43) {
            a6();
            total = 44;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 44) {
            b6();
            total = 45;
            multiplier.setText("B6 X1");


        } else if (efnotepatern.getText().equals("B6") && total == 45) {
            fsharp6();
            total = 46;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 46) {
            d6();
            total = 47;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 47) {
            e6();
            total = 48;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 48) {
            fsharp6();
            total = 49;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 49) {
            g6();
            total = 50;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 50) {
            b6();
            total = 51;
            multiplier.setText("B6 X1");

        } else if (efnotepatern.getText().equals("B6") && total == 51) {
            a6();
            total = 52;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 52) {
            g6();
            total = 53;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 53) {
            fsharp6();
            total = 54;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 54) {
            d6();
            total = 55;
            multiplier.setText("D6 X2");

        } else if (efnotepatern.getText().equals("D6") && total == 55) {
            e6();
            total = 56;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("E6") && total == 56) {
            fsharp6();
            total = 57;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 57) {
            g6();
            total = 58;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 58) {
            e6();
            total = 59;
            multiplier.setText("E6 X2");

        } else if (efnotepatern.getText().equals("E6") && total == 59) {
            fsharp6();
            total = 60;
            multiplier.setText("F#6 X1");

        } else if (efnotepatern.getText().equals("F#6") && total == 60) {
            d6();
            total = 61;
            multiplier.setText("D6 X1");

        } else if (efnotepatern.getText().equals("D6") && total == 61){
            total = 62;
            scorepopsunshine();
        }
     }
    private void tagpuan(float pitch2) {
        pitch2 = (pitch2 / 350) + 30;

        String b = String.format("%.2f", pitch2);

        if (efnotepatern.getText().equals("G#6") && total == 0) {
            asharp6();
            total = 1;
            multiplier.setText("A#6 X1");
        } else if (efnotepatern.getText().equals("A#6") && total == 1) {
            c7();
            total = 2;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 2) {
            asharp6();
            total = 3;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 3) {
            gsharp6();
            total = 4;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 4) {
            gsharp6();
            total = 5;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 5) {
            g6();
            total = 6;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 6) {
            f6();
            total = 7;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 7) {
            g6();
            total = 8;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 8) {
            gsharp6();
            total = 9;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 9) {
            g6();
            total = 10;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 10) {
            f6();
            total = 11;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 11) {
            dsharp6();
            total = 12;
            multiplier.setText("D# X2");

        } else if (efnotepatern.getText().equals("D#6") && total == 12) {
            c6();
            total = 13;
            multiplier.setText("C6 X1");

        } else if (efnotepatern.getText().equals("C6") && total == 13) {
            gsharp6();
            total = 14;
            multiplier.setText("G#6 X3");

        } else if (efnotepatern.getText().equals("G#6") && total == 14) {
            asharp6();
            total = 15;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 15) {
            c6();
            total = 16;
            multiplier.setText("C6 X2");

        } else if (efnotepatern.getText().equals("C6") && total == 16) {
            asharp6();
            total = 17;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 17) {
            gsharp6();
            total = 18;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 18) {
            e6();
            total = 19;
            multiplier.setText("E6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 19) {
            f6();
            total = 20;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 20) {
            g6();
            total = 21;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 21) {
            gsharp6();
            total = 22;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 22) {
            a6();
            total = 23;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 23) {
            a7();
            total = 24;
            multiplier.setText("A7 X1");

        } else if (efnotepatern.getText().equals("A7") && total == 24) {
            c7();
            total = 25;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 25) {
            f6();
            total = 26;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 26) {
            gsharp6();
            total = 27;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 27) {
            asharp6();
            total = 28;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 28) {
            c7();
            total = 29;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 29) {
            asharp6();
            total = 30;
            multiplier.setText("A#6 X1");

        }else if (efnotepatern.getText().equals("A#6") && total == 30) {
            gsharp6();
            total = 31;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 31) {
            g6();
            total = 32;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 32) {
            f6();
            total = 33;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 33) {
            g6();
            total = 34;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 34) {
            gsharp6();
            total = 35;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 35) {
            g6();
            total = 36;
            multiplier.setText("G6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 36) {
            f6();
            total = 37;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 37) {
            dsharp6();
            total = 38;
            multiplier.setText("D#6 X2");

        } else if (efnotepatern.getText().equals("D#6") && total == 38) {
            c6();
            total = 39;
            multiplier.setText("C6 X1");

        }else if (efnotepatern.getText().equals("C6") && total == 39) {
            gsharp6();
            total = 40;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 40) {
            g6();
            total = 41;
            multiplier.setText("g6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 41) {
            f6();
            total = 42;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 42) {
            gsharp6();
            total = 43;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 43) {
            a6();
            total = 44;
            multiplier.setText("A6 X1");

        } else if (efnotepatern.getText().equals("A6") && total == 44) {
            c7();
            total = 45;
            multiplier.setText("C7 X1");

        } else if (efnotepatern.getText().equals("C7") && total == 45) {
            f6();
            total = 46;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 46) {
            dsharp6();
            total = 47;
            multiplier.setText("D#6 X2");

        } else if (efnotepatern.getText().equals("D#6") && total == 47) {
            f6();
            total = 48;
            multiplier.setText("F6 X1");

        } else if (efnotepatern.getText().equals("F6") && total == 48) {
            gsharp6();
            total = 49;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 49) {
            asharp6();
            total = 50;
            multiplier.setText("A#6 X1");

        } else if (efnotepatern.getText().equals("A#6") && total == 50) {
            c7();
            total = 51;
            multiplier.setText("C7 X2");

        } else if (efnotepatern.getText().equals("C7") && total == 51) {
            f6();
            total = 52;
            multiplier.setText("F6 X1");

        }else if (efnotepatern.getText().equals("F6") && total == 52) {
            gsharp6();
            total = 53;
            multiplier.setText("G#6 X3");

        } else if (efnotepatern.getText().equals("G#6") && total == 53) {
            g6();
            total = 54;
            multiplier.setText("g6 X1");

        } else if (efnotepatern.getText().equals("G6") && total == 54) {
            gsharp6();
            total = 55;
            multiplier.setText("G#6 X1");

        } else if (efnotepatern.getText().equals("G#6") && total == 55) {

            total = 56;

        }
    }
























        /*



*/

// scoring easy //////////////////////////////////////////
    public  void scoringtwinkletwinke() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);
        if (count <= 29) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");

        } else if ((count >= 30 && count <= 34)) {

            if(count == 30){
                percentage.setText("98%");
            }else if(count == 31){
                percentage.setText("96%");
            }else if(count == 32){
                percentage.setText("95%");
            }else if(count == 33){
                percentage.setText("93%");
            }else if(count == 34){
                percentage.setText("88%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 35 && count <= 39)) {


            if(count == 35){
                percentage.setText("87%");
            }else if(count == 36){
                percentage.setText("85%");
            }else if(count == 37){
                percentage.setText("83%");
            }else if(count == 38){
                percentage.setText("81%");
            }else if(count == 39){
                percentage.setText("79%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            status.setText("Good");

        } else if ((count >= 40 && count <= 44)) {

            if(count == 40){
                percentage.setText("78%");
            }else if(count == 41){
                percentage.setText("76%");
            }else if(count == 42){
                percentage.setText("75%");
            }else if(count == 43){
                percentage.setText("74%");
            }else if(count == 44){
                percentage.setText("73%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);

            status.setText("Poor");


        } else if ((count >= 45 && count <= 70)) {


            if(count >= 45 && count < 48){
                percentage.setText("71%");
            }else if(count >=48  && count < 53){
                percentage.setText("69%");
            }else if(count >= 53 && count < 57){
                percentage.setText("68%");
            }else if(count >= 57 && count < 63){
                percentage.setText("65%");
            }else if(count >= 63 && count < 70){
                percentage.setText("63%");

            }

            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if (count >= 70){
            percentage.setText("50%");
            status.setText("Practice More!!!");



        }

        tittleofthesong.setText(tittle.getText().toString());



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertEasy(tittle,remarks,score);
                Intent a = new Intent (easy_format_songs.this, easy_chooser.class);
                startActivity(a);
            }
        });
        dialog.show();

    }
    public  void scorepophappybirthday() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);

        if (count <= 63) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 64 && count <= 68) {

              if (count == 64){
                percentage.setText("99%");
            }else if (count == 65){
                percentage.setText("98%");
            }else if (count == 66){
                percentage.setText("97%");
            }else if (count == 67){
                percentage.setText("96%");
            }else if (count == 68){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 69 && count <= 77)) {
            if (count == 69){
                percentage.setText("94%");
            }else if (count == 70){
                percentage.setText("93%");
            }
            else if(count == 71){
                percentage.setText("92%");
            }else if(count == 72){
                percentage.setText("91%");
            }else if(count == 73){
                percentage.setText("90%");
            }else if(count == 74){
                percentage.setText("89%");
            }else if(count == 75){
                percentage.setText("88%");
            }else if(count == 76){
                percentage.setText("87%");
            }else if(count == 77){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 78 && count <= 85)) {


            if(count == 78){
                percentage.setText("85%");
            }else if(count == 79){
                percentage.setText("84%");
            }else if(count == 80){
                percentage.setText("83%");
            }else if(count == 81){
                percentage.setText("82%");
            }else if(count == 82){
                percentage.setText("81%");
            }else if(count == 83){
                percentage.setText("80%");
            }else if(count == 84){
                percentage.setText("79%");
            }else if(count == 85){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 86 && count <= 90)) {
           if(count == 86){
                percentage.setText("77%");
            }else if(count == 87){
                percentage.setText("76%");
            }else if(count == 88){
                percentage.setText("75%");
            }else if(count == 89){
                percentage.setText("74%");
            }else if(count == 90){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 91 && count <= 100)) {

            if(count == 91){
                percentage.setText("72%");
            }else if(count == 92){
                percentage.setText("71%");
            }else if(count == 93){
                percentage.setText("70%");
            }else if(count == 94){
                percentage.setText("69%");
            }else if(count == 95){
                percentage.setText("68%");
            }else if(count == 96){
                percentage.setText("67%");
            }
            else if(count == 97){
                percentage.setText("66%");
            }else if(count == 98){
                percentage.setText("65%");
            }else if(count == 99){
                percentage.setText("64%");
            }else if(count == 100){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 101 && count <= 112) {

            if(count == 101){
                percentage.setText("62%");
            }else if(count == 102){
                percentage.setText("61%");
            }else if(count == 103){
                percentage.setText("60%");
            }else if(count == 104){
                percentage.setText("59%");
            }else if(count == 105){
                percentage.setText("58%");
            }else if(count == 106){
                percentage.setText("57%");
            }else if(count == 107){
                percentage.setText("56%");
            }else if(count == 108){
                percentage.setText("55%");
            }else if(count == 109){
                percentage.setText("54%");
            }else if(count == 110){
                percentage.setText("53%");
            }else if(count == 111){
                percentage.setText("52%");
            }else if(count == 112){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 113){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }




        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertEasy(tittle,remarks,score);
                Intent a = new Intent (easy_format_songs.this, easy_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }
    public  void scorepopincywincy() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);
        if (count <= 48) {
            percentage.setText("100%");
            status.setText("Exellent");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);




        } else if (count >= 49 && count <= 53 ) {

            if (count == 49){
                percentage.setText("99%");
            }else if (count == 50){
                percentage.setText("98%");
            }else if (count == 51){
                percentage.setText("97%");
            }else if (count == 52){
                percentage.setText("96%");
            }else if (count == 53){
                percentage.setText("95%");
            }

            status.setText("Exellent");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);



        } else if ((count >= 54 && count <= 62)) {
            if (count == 54){
                percentage.setText("94%");
            }else if (count == 55){
                percentage.setText("93%");
            }
            else if(count == 56){
                percentage.setText("92%");
            }else if(count == 57){
                percentage.setText("91%");
            }else if(count == 58){
                percentage.setText("90%");
            }else if(count == 59){
                percentage.setText("89%");
            }else if(count == 60){
                percentage.setText("88%");
            }else if(count == 61){
                percentage.setText("87%");
            }else if(count == 62){
                percentage.setText("86%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 63 && count <= 70)) {


            if(count == 63){
                percentage.setText("85%");
            }else if(count == 64){
                percentage.setText("84%");
            }else if(count == 65){
                percentage.setText("83%");
            }else if(count == 66){
                percentage.setText("82%");
            }else if(count == 67){
                percentage.setText("81%");
            }else if(count == 68){
                percentage.setText("80%");
            }
            else if(count == 69){
                percentage.setText("79%");
            }else if(count == 70){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            status.setText("Good");

        } else if ((count >= 71 && count <= 75)) {
            if(count == 71){
                percentage.setText("77%");
            }else if(count == 72){
                percentage.setText("76%");
            }else if(count == 73){
                percentage.setText("75%");
            }else if(count == 74){
                percentage.setText("74%");
            }
            else if(count == 75){
                percentage.setText("73%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");


        } else if ((count >= 76 && count <= 86)) {

            if(count == 76){
                percentage.setText("72%");
            }else if(count == 77){
                percentage.setText("71%");
            }else if(count == 78){
                percentage.setText("70%");
            }else if(count == 79){
                percentage.setText("69%");
            }else if(count == 80){
                percentage.setText("68%");
            }else if(count == 81){
                percentage.setText("67%");
            }
            else if(count == 82){
                percentage.setText("66%");
            }else if(count == 83){
                percentage.setText("65%");
            }else if(count == 84){
                percentage.setText("64%");
            }else if(count == 85){
                percentage.setText("63%");
            }else if(count == 86){
                percentage.setText("62%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            status.setText("Practice More !!!");

        } else if (count >= 87 && count <= 97){
             if(count == 87){
                percentage.setText("61%");
            }else if(count == 88){
                percentage.setText("60%");
            }else if(count == 89){
                percentage.setText("59%");
            }else if(count == 90){
                percentage.setText("58%");
            }else if(count == 91){
                percentage.setText("57%");
            }else if(count == 92){
                percentage.setText("56%");
            }else if(count == 93){
                percentage.setText("55%");
            }else if(count == 94){
                percentage.setText("54%");
            }else if(count == 95){
                percentage.setText("53%");
            }else if(count == 96){
                percentage.setText("52%");
            }else if(count == 97){
                percentage.setText("51%");
            }
            status.setText("Practice More !!!");


        }

        else if(count >= 98){
            percentage.setText("50%");
            star1.setBackgroundResource(R.mipmap.starscore);
            status.setText("Practice More !!!");

        }

        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertEasy(tittle,remarks,score);
                Intent a = new Intent (easy_format_songs.this, easy_chooser.class);
                startActivity(a);
            }
        });
        dialog.show();

    }
    public  void scorepopbabablacksheep() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);
        if (count <= 25 ) {
            status.setText("Exellent");
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);

        } else if (count >=26  && count <= 30) {
            if (count == 26){
                percentage.setText("99%");
            }else if (count == 27){
                percentage.setText("98%");
            }else if (count == 28){
                percentage.setText("97%");
            }else if (count == 29){
                percentage.setText("96%");
            }else if (count == 30){
                percentage.setText("95%");
            }
            status.setText("Exellent");

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);



        } else if ((count >= 31 && count <= 39)) {
            if (count == 31){
                percentage.setText("94%");
            }else if (count == 32){
                percentage.setText("93%");
            }
            else if(count == 33){
                percentage.setText("92%");
            }else if(count == 34){
                percentage.setText("91%");
            }else if(count == 35){
                percentage.setText("90%");
            }else if(count == 36){
                percentage.setText("89%");
            }else if(count == 37){
                percentage.setText("88%");
            }else if(count == 38){
                percentage.setText("87%");
            }else if(count == 39){
                percentage.setText("86%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 40 && count <= 47)) {


            if(count == 40){
                percentage.setText("85%");
            }else if(count == 41){
                percentage.setText("84%");
            }else if(count == 42){
                percentage.setText("83%");
            }else if(count == 43){
                percentage.setText("82%");
            }else if(count == 44){
                percentage.setText("81%");
            }else if(count == 45){
                percentage.setText("80%");
            }
            else if(count == 46){
                percentage.setText("79%");
            }else if(count == 47){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 48 && count <= 52)) {
            if(count == 48){
                percentage.setText("77%");
            }else if(count == 49){
                percentage.setText("76%");
            }else if(count == 50){
                percentage.setText("75%");
            }else if(count == 51){
                percentage.setText("74%");
            }
            else if(count == 52){
                percentage.setText("73%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");


        } else if ((count >= 53 && count <= 62)) {

            if(count == 53){
                percentage.setText("72%");
            }else if(count == 54){
                percentage.setText("71%");
            }else if(count == 55){
                percentage.setText("70%");
            }else if(count == 56){
                percentage.setText("69%");
            }else if(count == 57){
                percentage.setText("68%");
            }else if(count == 58){
                percentage.setText("67%");
            }else if(count == 59){
                percentage.setText("66%");
            }else if(count == 60){
                percentage.setText("65%");
            }else if(count == 61){
                percentage.setText("64%");
            }else if(count == 62){
                percentage.setText("63%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }
        else if (count >= 63 && count <= 74){
             if(count == 63){
                percentage.setText("62%");
            }else if(count == 64){
                percentage.setText("61%");
            }else if(count == 65){
                percentage.setText("60%");
            }else if(count == 66){
                percentage.setText("59%");
            }else if(count == 67){
                percentage.setText("58%");
            }else if(count == 68){
                percentage.setText("57%");
            }else if(count == 69){
                percentage.setText("56%");
            }else if(count == 70){
                percentage.setText("55%");
            }else if(count == 71){
                percentage.setText("54%");
            }else if(count == 72){
                percentage.setText("53%");
            }else if(count == 73){
                percentage.setText("52%");
            }else if(count == 74){
                percentage.setText("51%");
            }
            status.setText("Practice More!!!");


        }

        else if(count >= 75){
            percentage.setText("50%");
        }

        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertEasy(tittle,remarks,score);
                Intent a = new Intent (easy_format_songs.this, easy_chooser.class);
                startActivity(a);
            }
        });
        dialog.show();

    }
    public  void scorepopsilentnight() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);

        if (count < 53) {
            percentage.setText("100%");
            status.setText("Exellent");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);

        } else if (count >= 54 && count <= 58){
            if (count == 54){
                percentage.setText("99%");
            }else if (count == 55){
                percentage.setText("98%");
            }else if (count == 56){
                percentage.setText("97%");
            }else if (count == 57){
                percentage.setText("96%");
            }else if (count == 58){
                percentage.setText("95%");
            }
            status.setText("Exellent");

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);



        } else if ((count >= 59 && count <= 67)) {
            if (count == 59){
                percentage.setText("94%");
            }else if (count == 60){
                percentage.setText("93%");
            }else if(count == 61){
                percentage.setText("92%");
            }else if(count == 62){
                percentage.setText("91%");
            }else if(count == 63){
                percentage.setText("90%");
            }else if(count == 64){
                percentage.setText("89%");
            }else if(count == 65){
                percentage.setText("88%");
            }else if(count == 66){
                percentage.setText("87%");
            }else if(count == 67){
                percentage.setText("86%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 68 && count <= 75)) {


            if(count == 68){
                percentage.setText("85%");
            }else if(count == 69){
                percentage.setText("84%");
            }else if(count == 70){
                percentage.setText("83%");
            }else if(count == 71){
                percentage.setText("82%");
            }else if(count == 72){
                percentage.setText("81%");
            }else if(count == 73){
                percentage.setText("80%");
            }else if(count == 74){
                percentage.setText("79%");
            }else if(count == 75){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 76 && count <= 80)) {
             if(count == 76){
                percentage.setText("77%");
            }else if(count == 77){
                percentage.setText("76%");
            }else if(count == 78){
                percentage.setText("75%");
            }else if(count == 79){
                percentage.setText("74%");
            }else if(count == 80){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");


        } else if ((count >= 81 && count <= 90)) {

            if(count == 81){
                percentage.setText("72%");
            }else if(count == 82){
                percentage.setText("71%");
            }else if(count == 83){
                percentage.setText("70%");
            }else if(count == 84){
                percentage.setText("69%");
            }else if(count == 85){
                percentage.setText("68%");
            }else if(count == 86){
                percentage.setText("67%");
            }
            if(count == 87){
                percentage.setText("66%");
            }else if(count == 88){
                percentage.setText("65%");
            }else if(count == 89){
                percentage.setText("64%");
            }else if(count == 90){
                percentage.setText("63%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if (count>= 91 && count <= 102){
             if(count == 91){
                percentage.setText("62%");
            }else if(count == 92){
                percentage.setText("61%");
            }else if(count == 93){
                percentage.setText("60%");
            }else if(count == 94){
                percentage.setText("59%");
            }else if(count == 95){
                percentage.setText("58%");
            }else if(count == 96){
                percentage.setText("57%");
            }else if(count == 97){
                percentage.setText("56%");
            }else if(count == 98){
                percentage.setText("55%");
            }else if(count == 99){
                percentage.setText("54%");
            }else if(count == 100){
                percentage.setText("53%");
            }else if(count == 101){
                percentage.setText("52%");
            }else if(count == 102){
                percentage.setText("51%");
            }
            status.setText("Practice More!!!");

        }



        else if(count >= 103){
            percentage.setText("50%");
            status.setText("Practice More!!!");

        }
        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertEasy(tittle,remarks,score);
                Intent a = new Intent (easy_format_songs.this, easy_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }
    public  void scorepopjinglebells() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);
        if (count <= 48 ) {

            percentage.setText("100%");
            status.setText("Exellent");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);

        }

        else if (count >= 49 && count <= 53) {
            if (count == 49){
                percentage.setText("99%");
            }else if (count == 50){
                percentage.setText("98%");
            }else if (count == 51){
                percentage.setText("97%");
            }else if (count == 52){
                percentage.setText("96%");
            }else if (count == 53){
                percentage.setText("95%");
            }
            status.setText("Exellent");

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);



        } else if ((count >= 54 && count <= 62)) {
            if (count == 54){
                percentage.setText("94%");
            }else if (count == 55){
                percentage.setText("93%");
            }
            else if(count == 56){
                percentage.setText("92%");
            }else if(count == 57){
                percentage.setText("91%");
            }else if(count == 58){
                percentage.setText("90%");
            }else if(count == 59){
                percentage.setText("89%");
            }else if(count == 60){
                percentage.setText("88%");
            }else if(count == 61){
                percentage.setText("87%");
            }else if(count == 62){
                percentage.setText("86%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 63 && count <= 70)) {

            if(count == 63){
                percentage.setText("85%");
            }else if(count == 64){
                percentage.setText("84%");
            }else if(count == 65){
                percentage.setText("83%");
            }else if(count == 66){
                percentage.setText("82%");
            }else if(count == 67){
                percentage.setText("81%");
            }else if(count == 68){
                percentage.setText("80%");
            }else if(count == 69){
                percentage.setText("79%");
            }else if(count == 70){
                percentage.setText("78%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 71 && count <= 75)) {
             if(count == 71){
                percentage.setText("77%");
            }else if(count == 72){
                percentage.setText("76%");
            }else if(count == 73){
                percentage.setText("75%");
            }else if(count == 74){
                percentage.setText("74%");
            }else if(count == 75){
                percentage.setText("73%");
            }

            status.setText("Poor");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);


        } else if ((count >= 76 && count <= 85)) {

            if(count == 76){
                percentage.setText("72%");
            }else if(count == 77){
                percentage.setText("71%");
            }else if(count == 78){
                percentage.setText("70%");
            }else if(count == 79){
                percentage.setText("69%");
            }else if(count == 80){
                percentage.setText("68%");
            }else if(count == 81){
                percentage.setText("67%");
            }else if(count == 82){
                percentage.setText("66%");
            }else if(count == 83){
                percentage.setText("65%");
            }else if(count == 84){
                percentage.setText("64%");
            }else if(count == 85){
                percentage.setText("63%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }

        else if (count>=86 && count <= 97){

             if(count == 86){
                percentage.setText("62%");
            }else if(count == 87){
                percentage.setText("61%");
            }else if(count == 88){
                percentage.setText("60%");
            }else if(count == 89){
                percentage.setText("59%");
            }else if(count == 90){
                percentage.setText("58%");
            }else if(count == 91){
                percentage.setText("57%");
            }else if(count == 92){
                percentage.setText("56%");
            }else if(count == 93){
                percentage.setText("55%");
            }else if(count == 94){
                percentage.setText("54%");
            }else if(count == 95){
                percentage.setText("53%");
            }else if(count == 96){
                percentage.setText("52%");
            }else if(count == 97){
                percentage.setText("51%");
            }
            status.setText("Practice More!!!");
        }

        else if(count >= 98){
            percentage.setText("50%");
            status.setText("Practice More!!!");

        }
        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertEasy(tittle,remarks,score);
                Intent a = new Intent (easy_format_songs.this, easy_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }



    // scoring normal ///////////////////////////////////////
    public  void scorepopakoaymaylobo() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);

        if (count <= 33) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 34 && count <= 38) {

            if (count == 34){
                percentage.setText("99%");
            }else if (count == 35){
                percentage.setText("98%");
            }else if (count == 36){
                percentage.setText("97%");
            }else if (count == 37){
                percentage.setText("96%");
            }else if (count == 38){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 39 && count <= 47)) {
            if (count == 39){
                percentage.setText("94%");
            }else if (count == 40){
                percentage.setText("93%");
            }
            else if(count == 41){
                percentage.setText("92%");
            }else if(count == 42){
                percentage.setText("91%");
            }else if(count == 43){
                percentage.setText("90%");
            }else if(count == 44){
                percentage.setText("89%");
            }else if(count == 45){
                percentage.setText("88%");
            }else if(count == 46){
                percentage.setText("87%");
            }else if(count == 47){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 48 && count <= 55)) {


            if(count == 48){
                percentage.setText("85%");
            }else if(count == 49){
                percentage.setText("84%");
            }else if(count == 50){
                percentage.setText("83%");
            }else if(count == 51){
                percentage.setText("82%");
            }else if(count == 52){
                percentage.setText("81%");
            }else if(count == 53){
                percentage.setText("80%");
            }else if(count == 54){
                percentage.setText("79%");
            }else if(count == 55){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 56 && count <= 60)) {
            if(count == 56){
                percentage.setText("77%");
            }else if(count == 57){
                percentage.setText("76%");
            }else if(count == 58){
                percentage.setText("75%");
            }else if(count == 59){
                percentage.setText("74%");
            }else if(count == 60){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 61 && count <= 70)) {

            if(count == 61){
                percentage.setText("72%");
            }else if(count == 62){
                percentage.setText("71%");
            }else if(count == 63){
                percentage.setText("70%");
            }else if(count == 64){
                percentage.setText("69%");
            }else if(count == 65){
                percentage.setText("68%");
            }else if(count == 66){
                percentage.setText("67%");
            }
            else if(count == 67){
                percentage.setText("66%");
            }else if(count == 68){
                percentage.setText("65%");
            }else if(count == 69){
                percentage.setText("64%");
            }else if(count == 70){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 71 && count <= 82) {

            if(count == 71){
                percentage.setText("62%");
            }else if(count == 72){
                percentage.setText("61%");
            }else if(count == 73){
                percentage.setText("60%");
            }else if(count == 74){
                percentage.setText("59%");
            }else if(count == 75){
                percentage.setText("58%");
            }else if(count == 76){
                percentage.setText("57%");
            }else if(count == 77){
                percentage.setText("56%");
            }else if(count == 78){
                percentage.setText("55%");
            }else if(count == 79){
                percentage.setText("54%");
            }else if(count == 80){
                percentage.setText("53%");
            }else if(count == 81){
                percentage.setText("52%");
            }else if(count == 82){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 83){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }



        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertNormal(tittle,remarks,score);
                Intent a = new Intent(easy_format_songs.this, normal_chooser.class);
                startActivity(a);


            }

        });
        dialog.show();

    }
    public  void scorepopmaryhadalittlelamb() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);
        if (count <= 22) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 23 && count <= 27) {

            if (count == 23){
                percentage.setText("99%");
            }else if (count == 24){
                percentage.setText("98%");
            }else if (count == 25){
                percentage.setText("97%");
            }else if (count == 26){
                percentage.setText("96%");
            }else if (count == 27){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 28 && count <= 36)) {
            if (count == 28){
                percentage.setText("94%");
            }else if (count == 29){
                percentage.setText("93%");
            }
            else if(count == 30){
                percentage.setText("92%");
            }else if(count == 31){
                percentage.setText("91%");
            }else if(count == 32){
                percentage.setText("90%");
            }else if(count == 33){
                percentage.setText("89%");
            }else if(count == 34){
                percentage.setText("88%");
            }else if(count == 35){
                percentage.setText("87%");
            }else if(count == 36){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 37 && count <= 41)) {


            if(count == 37){
                percentage.setText("85%");
            }else if(count == 35){
                percentage.setText("84%");
            }else if(count == 36){
                percentage.setText("83%");
            }else if(count == 37){
                percentage.setText("82%");
            }else if(count == 38){
                percentage.setText("81%");
            }else if(count == 39){
                percentage.setText("80%");
            }else if(count == 40){
                percentage.setText("79%");
            }else if(count == 41){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 42 && count <= 46)) {
            if(count == 42){
                percentage.setText("77%");
            }else if(count == 43){
                percentage.setText("76%");
            }else if(count == 44){
                percentage.setText("75%");
            }else if(count == 45){
                percentage.setText("74%");
            }else if(count == 46){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 47 && count <= 56)) {

            if(count == 47){
                percentage.setText("72%");
            }else if(count == 48){
                percentage.setText("71%");
            }else if(count == 49){
                percentage.setText("70%");
            }else if(count == 50){
                percentage.setText("69%");
            }else if(count == 51){
                percentage.setText("68%");
            }else if(count == 52){
                percentage.setText("67%");
            }
            else if(count == 53){
                percentage.setText("66%");
            }else if(count == 54){
                percentage.setText("65%");
            }else if(count == 55){
                percentage.setText("64%");
            }else if(count == 56){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 57 && count <= 68) {

            if(count == 57){
                percentage.setText("62%");
            }else if(count == 58){
                percentage.setText("61%");
            }else if(count == 59){
                percentage.setText("60%");
            }else if(count == 60){
                percentage.setText("59%");
            }else if(count == 61){
                percentage.setText("58%");
            }else if(count == 62){
                percentage.setText("57%");
            }else if(count == 63){
                percentage.setText("56%");
            }else if(count == 64){
                percentage.setText("55%");
            }else if(count == 65){
                percentage.setText("54%");
            }else if(count == 66){
                percentage.setText("53%");
            }else if(count == 67){
                percentage.setText("52%");
            }else if(count == 68){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 69){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }






        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertNormal(tittle,remarks,score);
                Intent a = new Intent(easy_format_songs.this, normal_chooser.class);
                startActivity(a);


            }
        });
        dialog.show();

    }
    public  void scorepopleronleronsinta() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);


        if (count <= 33) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 34 && count <= 38) {

            if (count == 34){
                percentage.setText("99%");
            }else if (count == 35){
                percentage.setText("98%");
            }else if (count == 36){
                percentage.setText("97%");
            }else if (count == 37){
                percentage.setText("96%");
            }else if (count == 38){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 39 && count <= 47)) {
            if (count == 39){
                percentage.setText("94%");
            }else if (count == 40){
                percentage.setText("93%");
            }
            else if(count == 41){
                percentage.setText("92%");
            }else if(count == 42){
                percentage.setText("91%");
            }else if(count == 43){
                percentage.setText("90%");
            }else if(count == 44){
                percentage.setText("89%");
            }else if(count == 45){
                percentage.setText("88%");
            }else if(count == 46){
                percentage.setText("87%");
            }else if(count == 47){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 48 && count <= 55)) {


            if(count == 48){
                percentage.setText("85%");
            }else if(count == 49){
                percentage.setText("84%");
            }else if(count == 50){
                percentage.setText("83%");
            }else if(count == 51){
                percentage.setText("82%");
            }else if(count == 52){
                percentage.setText("81%");
            }else if(count == 53){
                percentage.setText("80%");
            }else if(count == 54){
                percentage.setText("79%");
            }else if(count == 55){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 56 && count <= 60)) {
            if(count == 56){
                percentage.setText("77%");
            }else if(count == 57){
                percentage.setText("76%");
            }else if(count == 58){
                percentage.setText("75%");
            }else if(count == 59){
                percentage.setText("74%");
            }else if(count == 60){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 61 && count <= 70)) {

            if(count == 61){
                percentage.setText("72%");
            }else if(count == 62){
                percentage.setText("71%");
            }else if(count == 63){
                percentage.setText("70%");
            }else if(count == 64){
                percentage.setText("69%");
            }else if(count == 65){
                percentage.setText("68%");
            }else if(count == 66){
                percentage.setText("67%");
            }else if(count == 67){
                percentage.setText("66%");
            }else if(count == 68){
                percentage.setText("65%");
            }else if(count == 69){
                percentage.setText("64%");
            }else if(count == 70){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 71 && count <= 82) {

            if(count == 71){
                percentage.setText("62%");
            }else if(count == 72){
                percentage.setText("61%");
            }else if(count == 73){
                percentage.setText("60%");
            }else if(count == 74){
                percentage.setText("59%");
            }else if(count == 75){
                percentage.setText("58%");
            }else if(count == 76){
                percentage.setText("57%");
            }else if(count == 77){
                percentage.setText("56%");
            }else if(count == 78){
                percentage.setText("55%");
            }else if(count == 79){
                percentage.setText("54%");
            }else if(count == 80){
                percentage.setText("53%");
            }else if(count == 81){
                percentage.setText("52%");
            }else if(count == 82){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 83){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }




        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertNormal(tittle,remarks,score);
                Intent a = new Intent(easy_format_songs.this, normal_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }
    public  void scorepoponeday() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);

        if (count <= 44) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 45 && count <= 49) {

            if (count == 45){
                percentage.setText("99%");
            }else if (count == 46){
                percentage.setText("98%");
            }else if (count == 47){
                percentage.setText("97%");
            }else if (count == 48){
                percentage.setText("96%");
            }else if (count == 49){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 50 && count <= 58)) {
            if (count == 50){
                percentage.setText("94%");
            }else if (count == 51){
                percentage.setText("93%");
            }
            else if(count == 52){
                percentage.setText("92%");
            }else if(count == 53){
                percentage.setText("91%");
            }else if(count == 54){
                percentage.setText("90%");
            }else if(count == 55){
                percentage.setText("89%");
            }else if(count == 56){
                percentage.setText("88%");
            }else if(count == 57){
                percentage.setText("87%");
            }else if(count == 58){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 59 && count <= 66)) {


            if(count == 59){
                percentage.setText("85%");
            }else if(count == 60){
                percentage.setText("84%");
            }else if(count == 61){
                percentage.setText("83%");
            }else if(count == 62){
                percentage.setText("82%");
            }else if(count == 63){
                percentage.setText("81%");
            }else if(count == 64){
                percentage.setText("80%");
            }else if(count == 65){
                percentage.setText("79%");
            }else if(count == 66){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 67 && count <= 71)) {
            if(count == 67){
                percentage.setText("77%");
            }else if(count == 68){
                percentage.setText("76%");
            }else if(count == 69){
                percentage.setText("75%");
            }else if(count == 70){
                percentage.setText("74%");
            }else if(count == 71){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 72 && count <= 81)) {

            if(count == 72){
                percentage.setText("72%");
            }else if(count == 73){
                percentage.setText("71%");
            }else if(count == 74){
                percentage.setText("70%");
            }else if(count == 75){
                percentage.setText("69%");
            }else if(count == 76){
                percentage.setText("68%");
            }else if(count == 77){
                percentage.setText("67%");
            }
            else if(count == 78){
                percentage.setText("66%");
            }else if(count == 79){
                percentage.setText("65%");
            }else if(count == 80){
                percentage.setText("64%");
            }else if(count == 81){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 82 && count <= 93) {

            if(count == 82){
                percentage.setText("62%");
            }else if(count == 83){
                percentage.setText("61%");
            }else if(count == 84){
                percentage.setText("60%");
            }else if(count == 85){
                percentage.setText("59%");
            }else if(count == 86){
                percentage.setText("58%");
            }else if(count == 87){
                percentage.setText("57%");
            }else if(count == 88){
                percentage.setText("56%");
            }else if(count == 89){
                percentage.setText("55%");
            }else if(count == 90){
                percentage.setText("54%");
            }else if(count == 91){
                percentage.setText("53%");
            }else if(count == 92){
                percentage.setText("52%");
            }else if(count == 93){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 94){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }




        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertNormal(tittle,remarks,score);
                Intent a = new Intent(easy_format_songs.this, normal_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }
    public  void scorepoplondonbridge() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);


        if (count <= 49) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 50 && count <= 54) {

            if (count == 50){
                percentage.setText("99%");
            }else if (count == 51){
                percentage.setText("98%");
            }else if (count == 52){
                percentage.setText("97%");
            }else if (count == 53){
                percentage.setText("96%");
            }else if (count == 54){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 55 && count <= 63)) {
            if (count == 55){
                percentage.setText("94%");
            }else if (count == 56){
                percentage.setText("93%");
            }else if (count == 57){
                percentage.setText("92%");
            }else if(count == 58){
                percentage.setText("91%");
            }else if(count == 59){
                percentage.setText("90%");
            }else if(count == 60){
                percentage.setText("89%");
            }else if(count == 61){
                percentage.setText("88%");
            }else if(count == 62){
                percentage.setText("87%");
            }else if(count == 63){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 64 && count <= 71)) {


            if(count == 64){
                percentage.setText("85%");
            }else if(count == 65){
                percentage.setText("84%");
            }else if(count == 66){
                percentage.setText("83%");
            }else if(count == 67){
                percentage.setText("82%");
            }else if(count == 68){
                percentage.setText("81%");
            }else if(count == 69){
                percentage.setText("80%");
            }else if(count == 70){
                percentage.setText("79%");
            }else if(count == 71){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 72 && count <= 76)) {
            if(count == 72){
                percentage.setText("77%");
            }else if(count == 73){
                percentage.setText("76%");
            }else if(count == 74){
                percentage.setText("75%");
            }else if(count == 75){
                percentage.setText("74%");
            }else if(count == 76){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 77 && count <= 86)) {

            if(count == 77){
                percentage.setText("72%");
            }else if(count == 78){
                percentage.setText("71%");
            }else if(count == 79){
                percentage.setText("70%");
            }else if(count == 80){
                percentage.setText("69%");
            }else if(count == 81){
                percentage.setText("68%");
            }else if(count == 82){
                percentage.setText("67%");
            }
            else if(count == 83){
                percentage.setText("66%");
            }else if(count == 84){
                percentage.setText("65%");
            }else if(count == 85){
                percentage.setText("64%");
            }else if(count == 86){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 87 && count <= 98) {

            if(count == 87){
                percentage.setText("62%");
            }else if(count == 88){
                percentage.setText("61%");
            }else if(count == 89){
                percentage.setText("60%");
            }else if(count == 90){
                percentage.setText("59%");
            }else if(count == 91){
                percentage.setText("58%");
            }else if(count == 92){
                percentage.setText("57%");
            }else if(count == 93){
                percentage.setText("56%");
            }else if(count == 94){
                percentage.setText("55%");
            }else if(count == 95){
                percentage.setText("54%");
            }else if(count == 96){
                percentage.setText("53%");
            }else if(count == 97){
                percentage.setText("52%");
            }else if(count == 98){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 94){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }



        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertNormal(tittle,remarks,score);
                Intent a = new Intent(easy_format_songs.this, normal_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }
    public  void scorepopmrbean() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);
        if (count <= 29) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 30 && count <= 34) {

            if (count == 30){
                percentage.setText("99%");
            }else if (count == 31){
                percentage.setText("98%");
            }else if (count == 32){
                percentage.setText("97%");
            }else if (count == 33){
                percentage.setText("96%");
            }else if (count == 34){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 35 && count <= 43)) {
            if (count == 35){
                percentage.setText("94%");
            }else if (count == 36){
                percentage.setText("93%");
            }
            else if(count == 37){
                percentage.setText("92%");
            }else if(count == 38){
                percentage.setText("91%");
            }else if(count == 39){
                percentage.setText("90%");
            }else if(count == 40){
                percentage.setText("89%");
            }else if(count == 41){
                percentage.setText("88%");
            }else if(count == 42){
                percentage.setText("87%");
            }else if(count == 43){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 44 && count <= 51)) {


            if(count == 44){
                percentage.setText("85%");
            }else if(count == 45){
                percentage.setText("84%");
            }else if(count == 46){
                percentage.setText("83%");
            }else if(count == 47){
                percentage.setText("82%");
            }else if(count == 48){
                percentage.setText("81%");
            }else if(count == 49){
                percentage.setText("80%");
            }else if(count == 50){
                percentage.setText("79%");
            }else if(count == 51){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 52 && count <= 56)) {
            if(count == 52){
                percentage.setText("77%");
            }else if(count == 53){
                percentage.setText("76%");
            }else if(count == 54){
                percentage.setText("75%");
            }else if(count == 55){
                percentage.setText("74%");
            }else if(count == 56){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 57 && count <= 66)) {

            if(count == 57){
                percentage.setText("72%");
            }else if(count == 58){
                percentage.setText("71%");
            }else if(count == 59){
                percentage.setText("70%");
            }else if(count == 60){
                percentage.setText("69%");
            }else if(count == 61){
                percentage.setText("68%");
            }else if(count == 62){
                percentage.setText("67%");
            }
            else if(count == 63){
                percentage.setText("66%");
            }else if(count == 64){
                percentage.setText("65%");
            }else if(count == 65){
                percentage.setText("64%");
            }else if(count == 66){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 67 && count <= 78) {

            if(count == 67){
                percentage.setText("62%");
            }else if(count == 68){
                percentage.setText("61%");
            }else if(count == 69){
                percentage.setText("60%");
            }else if(count == 70){
                percentage.setText("59%");
            }else if(count == 71){
                percentage.setText("58%");
            }else if(count == 72){
                percentage.setText("57%");
            }else if(count == 73){
                percentage.setText("56%");
            }else if(count == 74){
                percentage.setText("55%");
            }else if(count == 75){
                percentage.setText("54%");
            }else if(count == 76){
                percentage.setText("53%");
            }else if(count == 77){
                percentage.setText("52%");
            }else if(count == 78){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 79){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }





        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertNormal(tittle,remarks,score);
                Intent a = new Intent(easy_format_songs.this, normal_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }





    // scoring hard ////////////////////////////////////////
public  void scoringdaysofchristmas  () {
    dialog.setContentView(R.layout.scorepopup);
    final TextView tittleofthesong, status, percentage;
    ImageView star1, star2, star3, star4, star5;
    Button next;
    next = (Button) dialog.findViewById(R.id.next);
    percentage = (TextView) dialog.findViewById(R.id.percentage);
    star1 = (ImageView) dialog.findViewById(R.id.star1);
    star2 = (ImageView) dialog.findViewById(R.id.star2);
    star3 = (ImageView) dialog.findViewById(R.id.star3);
    star4 = (ImageView) dialog.findViewById(R.id.star4);
    star5 = (ImageView) dialog.findViewById(R.id.star5);
    tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
    status = (TextView) dialog.findViewById(R.id.status);



    if (count <= 68) {
        percentage.setText("100%");
        star1.setBackgroundResource(R.mipmap.starscore);
        star2.setBackgroundResource(R.mipmap.starscore);
        star3.setBackgroundResource(R.mipmap.starscore);
        star4.setBackgroundResource(R.mipmap.starscore);
        star5.setBackgroundResource(R.mipmap.starscore);
        status.setText("Exellent");


    }
    else if (count >= 69 && count <= 73) {

        if (count == 69){
            percentage.setText("99%");
        }else if (count == 70){
            percentage.setText("98%");
        }else if (count == 71){
            percentage.setText("97%");
        }else if (count == 72){
            percentage.setText("96%");
        }else if (count == 73){
            percentage.setText("95%");
        }

        star1.setBackgroundResource(R.mipmap.starscore);
        star2.setBackgroundResource(R.mipmap.starscore);
        star3.setBackgroundResource(R.mipmap.starscore);
        star4.setBackgroundResource(R.mipmap.starscore);
        star5.setBackgroundResource(R.mipmap.starscore);
        status.setText("Exellent");



    } else if ((count >= 74 && count <= 82)) {
        if (count == 74){
            percentage.setText("94%");
        }else if (count == 75){
            percentage.setText("93%");
        }
        else if(count == 76){
            percentage.setText("92%");
        }else if(count == 77){
            percentage.setText("91%");
        }else if(count == 78){
            percentage.setText("90%");
        }else if(count == 79){
            percentage.setText("89%");
        }else if(count == 80){
            percentage.setText("88%");
        }else if(count == 81){
            percentage.setText("87%");
        }else if(count == 82){
            percentage.setText("86%");
        }


        star1.setBackgroundResource(R.mipmap.starscore);
        star2.setBackgroundResource(R.mipmap.starscore);
        star3.setBackgroundResource(R.mipmap.starscore);
        star4.setBackgroundResource(R.mipmap.starscore);
        status.setText("Very Good");







    } else if ((count >= 83 && count <= 90)) {


        if(count == 83){
            percentage.setText("85%");
        }else if(count == 84){
            percentage.setText("84%");
        }else if(count == 85){
            percentage.setText("83%");
        }else if(count == 86){
            percentage.setText("82%");
        }else if(count == 87){
            percentage.setText("81%");
        }else if(count == 88){
            percentage.setText("80%");
        }else if(count == 89){
            percentage.setText("79%");
        }else if(count == 90){
            percentage.setText("78%");
        }

        star1.setBackgroundResource(R.mipmap.starscore);
        star2.setBackgroundResource(R.mipmap.starscore);
        star3.setBackgroundResource(R.mipmap.starscore);

        status.setText("Good");

    } else if ((count >= 91 && count <= 95)) {
        if(count == 91){
            percentage.setText("77%");
        }else if(count == 92){
            percentage.setText("76%");
        }else if(count == 93){
            percentage.setText("75%");
        }else if(count == 94){
            percentage.setText("74%");
        }else if(count == 95){
            percentage.setText("73%");
        }

        star1.setBackgroundResource(R.mipmap.starscore);
        star2.setBackgroundResource(R.mipmap.starscore);
        status.setText("Poor");

    } else if ((count >= 96 && count <= 105)) {

        if(count == 96){
            percentage.setText("72%");
        }else if(count == 97){
            percentage.setText("71%");
        }else if(count == 98){
            percentage.setText("70%");
        }else if(count == 99){
            percentage.setText("69%");
        }else if(count == 100){
            percentage.setText("68%");
        }else if(count == 101){
            percentage.setText("67%");
        }
        else if(count == 102){
            percentage.setText("66%");
        }else if(count == 103){
            percentage.setText("65%");
        }else if(count == 104){
            percentage.setText("64%");
        }else if(count == 105){
            percentage.setText("63%");
        }
        star1.setBackgroundResource(R.mipmap.starscore);

        status.setText("Practice More!!!");

    }else if(count >= 106 && count <= 117) {

        if(count == 106){
            percentage.setText("62%");
        }else if(count == 107){
            percentage.setText("61%");
        }else if(count == 108){
            percentage.setText("60%");
        }else if(count == 109){
            percentage.setText("59%");
        }else if(count == 110){
            percentage.setText("58%");
        }else if(count == 111){
            percentage.setText("57%");
        }else if(count == 112){
            percentage.setText("56%");
        }else if(count == 113){
            percentage.setText("55%");
        }else if(count == 114){
            percentage.setText("54%");
        }else if(count == 115){
            percentage.setText("53%");
        }else if(count == 116){
            percentage.setText("52%");
        }else if(count == 117){
            percentage.setText("51%");
        }

        status.setText("Practice More!!!");


    }
    else if(count >= 118){

        percentage.setText("50%");


        status.setText("Practice More!!!");


    }


    tittleofthesong.setText(tittle.getText().toString());




    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String tittle = tittleofthesong.getText().toString();
            String remarks = status.getText().toString();
            String score = percentage.getText().toString();
            DbHandler dbHandler = new DbHandler(easy_format_songs.this);
            dbHandler.InsertHard(tittle,remarks,score);
            Intent a = new Intent(easy_format_songs.this, hard_chooser.class);
            startActivity(a);

        }
    });
    dialog.show();

}
    public  void scoringisntshelovely  () {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);

        if (count <= 36) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 37 && count <= 41) {

            if (count == 37){
                percentage.setText("99%");
            }else if (count == 38){
                percentage.setText("98%");
            }else if (count == 39){
                percentage.setText("97%");
            }else if (count == 40){
                percentage.setText("96%");
            }else if (count == 41){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 42 && count <= 50)) {
            if (count == 42){
                percentage.setText("94%");
            }else if (count == 43){
                percentage.setText("93%");
            }
            else if(count == 44){
                percentage.setText("92%");
            }else if(count == 45){
                percentage.setText("91%");
            }else if(count == 46){
                percentage.setText("90%");
            }else if(count == 47){
                percentage.setText("89%");
            }else if(count == 48){
                percentage.setText("88%");
            }else if(count == 49){
                percentage.setText("87%");
            }else if(count == 50){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 51 && count <= 58)) {


            if(count == 51){
                percentage.setText("85%");
            }else if(count == 52){
                percentage.setText("84%");
            }else if(count == 53){
                percentage.setText("83%");
            }else if(count == 54){
                percentage.setText("82%");
            }else if(count == 55){
                percentage.setText("81%");
            }else if(count == 56){
                percentage.setText("80%");
            }else if(count == 57){
                percentage.setText("79%");
            }else if(count == 58){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 59 && count <= 63)) {
            if(count == 59){
                percentage.setText("77%");
            }else if(count == 60){
                percentage.setText("76%");
            }else if(count == 61){
                percentage.setText("75%");
            }else if(count == 62){
                percentage.setText("74%");
            }else if(count == 63){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 64 && count <= 73)) {

            if(count == 64){
                percentage.setText("72%");
            }else if(count == 65){
                percentage.setText("71%");
            }else if(count == 66){
                percentage.setText("70%");
            }else if(count == 67){
                percentage.setText("69%");
            }else if(count == 68){
                percentage.setText("68%");
            }else if(count == 69){
                percentage.setText("67%");
            }
            else if(count == 70){
                percentage.setText("66%");
            }else if(count == 71){
                percentage.setText("65%");
            }else if(count == 72){
                percentage.setText("64%");
            }else if(count == 73){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 74 && count <= 85) {

            if(count == 74){
                percentage.setText("62%");
            }else if(count == 75){
                percentage.setText("61%");
            }else if(count == 76){
                percentage.setText("60%");
            }else if(count == 77){
                percentage.setText("59%");
            }else if(count == 78){
                percentage.setText("58%");
            }else if(count == 79){
                percentage.setText("57%");
            }else if(count == 80){
                percentage.setText("56%");
            }else if(count == 81){
                percentage.setText("55%");
            }else if(count == 82){
                percentage.setText("54%");
            }else if(count == 83){
                percentage.setText("53%");
            }else if(count == 84){
                percentage.setText("52%");
            }else if(count == 85){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 86){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }




        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertHard(tittle,remarks,score);

                Intent a = new Intent(easy_format_songs.this, hard_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }
    public  void scoringangpaskoaysumapit  () {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);


        if (count <= 53) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 54 && count <= 59) {

            if (count == 55){
                percentage.setText("99%");
            }else if (count == 56){
                percentage.setText("98%");
            }else if (count == 57){
                percentage.setText("97%");
            }else if (count == 58){
                percentage.setText("96%");
            }else if (count == 59){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 60 && count <= 68)) {
            if (count == 60){
                percentage.setText("94%");
            }else if (count == 61){
                percentage.setText("93%");
            }
            else if(count == 62){
                percentage.setText("92%");
            }else if(count == 63){
                percentage.setText("91%");
            }else if(count == 64){
                percentage.setText("90%");
            }else if(count == 65){
                percentage.setText("89%");
            }else if(count == 66){
                percentage.setText("88%");
            }else if(count == 67){
                percentage.setText("87%");
            }else if(count == 68){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 69 && count <= 76)) {


            if(count == 69){
                percentage.setText("85%");
            }else if(count == 70){
                percentage.setText("84%");
            }else if(count == 71){
                percentage.setText("83%");
            }else if(count == 72){
                percentage.setText("82%");
            }else if(count == 73){
                percentage.setText("81%");
            }else if(count == 74){
                percentage.setText("80%");
            }else if(count == 75){
                percentage.setText("79%");
            }else if(count == 76){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 77 && count <= 81)) {
            if(count == 77){
                percentage.setText("77%");
            }else if(count == 78){
                percentage.setText("76%");
            }else if(count == 79){
                percentage.setText("75%");
            }else if(count == 80){
                percentage.setText("74%");
            }else if(count == 81){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 82 && count <= 91)) {

            if(count == 82){
                percentage.setText("72%");
            }else if(count == 83){
                percentage.setText("71%");
            }else if(count == 84){
                percentage.setText("70%");
            }else if(count == 85){
                percentage.setText("69%");
            }else if(count == 86){
                percentage.setText("68%");
            }else if(count == 87){
                percentage.setText("67%");
            }
            else if(count == 88){
                percentage.setText("66%");
            }else if(count == 89){
                percentage.setText("65%");
            }else if(count == 90){
                percentage.setText("64%");
            }else if(count == 91){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 92 && count <= 103) {

            if(count == 92){
                percentage.setText("62%");
            }else if(count == 93){
                percentage.setText("61%");
            }else if(count == 94){
                percentage.setText("60%");
            }else if(count == 95){
                percentage.setText("59%");
            }else if(count == 96){
                percentage.setText("58%");
            }else if(count == 97){
                percentage.setText("57%");
            }else if(count == 98){
                percentage.setText("56%");
            }else if(count == 99){
                percentage.setText("55%");
            }else if(count == 100){
                percentage.setText("54%");
            }else if(count == 101){
                percentage.setText("53%");
            }else if(count == 102){
                percentage.setText("52%");
            }else if(count == 103){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 104){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }



        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertHard(tittle,remarks,score);
                Intent a = new Intent(easy_format_songs.this, hard_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }
    public  void scoringparuparongbukid() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);
        if (count <= 42) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 43 && count <= 47) {

            if (count == 43){
                percentage.setText("99%");
            }else if (count == 44){
                percentage.setText("98%");
            }else if (count == 45){
                percentage.setText("97%");
            }else if (count == 46){
                percentage.setText("96%");
            }else if (count == 47){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 48 && count <= 56)) {
            if (count == 48){
                percentage.setText("94%");
            }else if (count == 49){
                percentage.setText("93%");
            }
            else if(count == 50){
                percentage.setText("92%");
            }else if(count == 51){
                percentage.setText("91%");
            }else if(count == 52){
                percentage.setText("90%");
            }else if(count == 53){
                percentage.setText("89%");
            }else if(count == 54){
                percentage.setText("88%");
            }else if(count == 55){
                percentage.setText("87%");
            }else if(count == 56){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 57 && count <= 64)) {


            if(count == 57){
                percentage.setText("85%");
            }else if(count == 58){
                percentage.setText("84%");
            }else if(count == 59){
                percentage.setText("83%");
            }else if(count == 60){
                percentage.setText("82%");
            }else if(count == 61){
                percentage.setText("81%");
            }else if(count == 62){
                percentage.setText("80%");
            }else if(count == 63){
                percentage.setText("79%");
            }else if(count == 64){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 65 && count <= 69)) {
            if(count == 65){
                percentage.setText("77%");
            }else if(count == 66){
                percentage.setText("76%");
            }else if(count == 67){
                percentage.setText("75%");
            }else if(count == 68){
                percentage.setText("74%");
            }else if(count == 69){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 70 && count <= 79)) {

            if(count == 70){
                percentage.setText("72%");
            }else if(count == 71){
                percentage.setText("71%");
            }else if(count == 72){
                percentage.setText("70%");
            }else if(count == 73){
                percentage.setText("69%");
            }else if(count == 74){
                percentage.setText("68%");
            }else if(count == 75){
                percentage.setText("67%");
            }
            else if(count == 76){
                percentage.setText("66%");
            }else if(count == 77){
                percentage.setText("65%");
            }else if(count == 78){
                percentage.setText("64%");
            }else if(count == 79){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 79 && count <= 90) {

            if(count == 79){
                percentage.setText("62%");
            }else if(count == 80){
                percentage.setText("61%");
            }else if(count == 81){
                percentage.setText("60%");
            }else if(count == 82){
                percentage.setText("59%");
            }else if(count == 83){
                percentage.setText("58%");
            }else if(count == 84){
                percentage.setText("57%");
            }else if(count == 85){
                percentage.setText("56%");
            }else if(count == 86){
                percentage.setText("55%");
            }else if(count == 87){
                percentage.setText("54%");
            }else if(count == 88){
                percentage.setText("53%");
            }else if(count == 89){
                percentage.setText("52%");
            }else if(count == 90){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 91){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }




        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertHard(tittle,remarks,score);

                Intent a = new Intent(easy_format_songs.this, hard_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }
    public  void scoringikaw() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);
        if (count <= 82) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 83 && count <= 87) {

            if (count == 83){
                percentage.setText("99%");
            }else if (count == 84){
                percentage.setText("98%");
            }else if (count == 85){
                percentage.setText("97%");
            }else if (count == 86){
                percentage.setText("96%");
            }else if (count == 87){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 88 && count <= 96)) {
            if (count == 88){
                percentage.setText("94%");
            }else if (count == 89){
                percentage.setText("93%");
            }
            else if(count == 90){
                percentage.setText("92%");
            }else if(count == 91){
                percentage.setText("91%");
            }else if(count == 92){
                percentage.setText("90%");
            }else if(count == 93){
                percentage.setText("89%");
            }else if(count == 94){
                percentage.setText("88%");
            }else if(count == 95){
                percentage.setText("87%");
            }else if(count == 96){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 97 && count <= 104)) {


            if(count == 97){
                percentage.setText("85%");
            }else if(count == 98){
                percentage.setText("84%");
            }else if(count == 99){
                percentage.setText("83%");
            }else if(count == 100){
                percentage.setText("82%");
            }else if(count == 101){
                percentage.setText("81%");
            }else if(count == 102){
                percentage.setText("80%");
            }else if(count == 103){
                percentage.setText("79%");
            }else if(count == 104){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 105 && count <= 109)) {
            if(count == 105){
                percentage.setText("77%");
            }else if(count == 106){
                percentage.setText("76%");
            }else if(count == 107){
                percentage.setText("75%");
            }else if(count == 108){
                percentage.setText("74%");
            }else if(count == 109){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 110 && count <= 119)) {

            if(count == 110){
                percentage.setText("72%");
            }else if(count == 111){
                percentage.setText("71%");
            }else if(count == 112){
                percentage.setText("70%");
            }else if(count == 113){
                percentage.setText("69%");
            }else if(count == 114){
                percentage.setText("68%");
            }else if(count == 115){
                percentage.setText("67%");
            }
            else if(count == 116){
                percentage.setText("66%");
            }else if(count == 117){
                percentage.setText("65%");
            }else if(count == 118){
                percentage.setText("64%");
            }else if(count == 119){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 120 && count <= 131) {

            if(count == 120){
                percentage.setText("62%");
            }else if(count == 121){
                percentage.setText("61%");
            }else if(count == 122){
                percentage.setText("60%");
            }else if(count == 123){
                percentage.setText("59%");
            }else if(count == 124){
                percentage.setText("58%");
            }else if(count == 125){
                percentage.setText("57%");
            }else if(count == 126){
                percentage.setText("56%");
            }else if(count == 127){
                percentage.setText("55%");
            }else if(count == 128){
                percentage.setText("54%");
            }else if(count == 129){
                percentage.setText("53%");
            }else if(count == 130){
                percentage.setText("52%");
            }else if(count == 131){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 132){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }






        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertHard(tittle,remarks,score);

                Intent a = new Intent(easy_format_songs.this, hard_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }
    public  void scorepopsunshine() {
        dialog.setContentView(R.layout.scorepopup);
        final TextView tittleofthesong, status, percentage;
        ImageView star1, star2, star3, star4, star5;
        Button next;
        next = (Button) dialog.findViewById(R.id.next);
        percentage = (TextView) dialog.findViewById(R.id.percentage);
        star1 = (ImageView) dialog.findViewById(R.id.star1);
        star2 = (ImageView) dialog.findViewById(R.id.star2);
        star3 = (ImageView) dialog.findViewById(R.id.star3);
        star4 = (ImageView) dialog.findViewById(R.id.star4);
        star5 = (ImageView) dialog.findViewById(R.id.star5);
        tittleofthesong = (TextView) dialog.findViewById(R.id.tittleofthesong);
        status = (TextView) dialog.findViewById(R.id.status);

        if (count <= 60) {
            percentage.setText("100%");
            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");


        }
        else if (count >= 61 && count <= 65) {

            if (count == 61){
                percentage.setText("99%");
            }else if (count == 62){
                percentage.setText("98%");
            }else if (count == 63){
                percentage.setText("97%");
            }else if (count == 64){
                percentage.setText("96%");
            }else if (count == 65){
                percentage.setText("95%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            star5.setBackgroundResource(R.mipmap.starscore);
            status.setText("Exellent");



        } else if ((count >= 66 && count <= 74)) {
            if (count == 66){
                percentage.setText("94%");
            }else if (count == 67){
                percentage.setText("93%");
            }
            else if(count == 68){
                percentage.setText("92%");
            }else if(count == 69){
                percentage.setText("91%");
            }else if(count == 70){
                percentage.setText("90%");
            }else if(count == 71){
                percentage.setText("89%");
            }else if(count == 72){
                percentage.setText("88%");
            }else if(count == 73){
                percentage.setText("87%");
            }else if(count == 74){
                percentage.setText("86%");
            }


            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);
            star4.setBackgroundResource(R.mipmap.starscore);
            status.setText("Very Good");







        } else if ((count >= 75 && count <= 82)) {


            if(count == 75){
                percentage.setText("85%");
            }else if(count == 76){
                percentage.setText("84%");
            }else if(count == 77){
                percentage.setText("83%");
            }else if(count == 78){
                percentage.setText("82%");
            }else if(count == 79){
                percentage.setText("81%");
            }else if(count == 80){
                percentage.setText("80%");
            }else if(count == 81){
                percentage.setText("79%");
            }else if(count == 82){
                percentage.setText("78%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            star3.setBackgroundResource(R.mipmap.starscore);

            status.setText("Good");

        } else if ((count >= 83 && count <= 87)) {
            if(count == 83){
                percentage.setText("77%");
            }else if(count == 84){
                percentage.setText("76%");
            }else if(count == 85){
                percentage.setText("75%");
            }else if(count == 86){
                percentage.setText("74%");
            }else if(count == 87){
                percentage.setText("73%");
            }

            star1.setBackgroundResource(R.mipmap.starscore);
            star2.setBackgroundResource(R.mipmap.starscore);
            status.setText("Poor");

        } else if ((count >= 88 && count <= 97)) {

            if(count == 88){
                percentage.setText("72%");
            }else if(count == 89){
                percentage.setText("71%");
            }else if(count == 90){
                percentage.setText("70%");
            }else if(count == 91){
                percentage.setText("69%");
            }else if(count == 92){
                percentage.setText("68%");
            }else if(count == 93){
                percentage.setText("67%");
            }
            else if(count == 94){
                percentage.setText("66%");
            }else if(count == 95){
                percentage.setText("65%");
            }else if(count == 96){
                percentage.setText("64%");
            }else if(count == 97){
                percentage.setText("63%");
            }
            star1.setBackgroundResource(R.mipmap.starscore);

            status.setText("Practice More!!!");

        }else if(count >= 98 && count <= 109) {

            if(count == 98){
                percentage.setText("62%");
            }else if(count == 99){
                percentage.setText("61%");
            }else if(count == 100){
                percentage.setText("60%");
            }else if(count == 101){
                percentage.setText("59%");
            }else if(count == 102){
                percentage.setText("58%");
            }else if(count == 103){
                percentage.setText("57%");
            }else if(count == 104){
                percentage.setText("56%");
            }else if(count == 105){
                percentage.setText("55%");
            }else if(count == 106){
                percentage.setText("54%");
            }else if(count == 107){
                percentage.setText("53%");
            }else if(count == 108){
                percentage.setText("52%");
            }else if(count == 109){
                percentage.setText("51%");
            }

            status.setText("Practice More!!!");


        }
        else if(count >= 110){

            percentage.setText("50%");


            status.setText("Practice More!!!");


        }




        tittleofthesong.setText(tittle.getText().toString());




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = tittleofthesong.getText().toString();
                String remarks = status.getText().toString();
                String score = percentage.getText().toString();
                DbHandler dbHandler = new DbHandler(easy_format_songs.this);
                dbHandler.InsertHard(tittle,remarks,score);

                Intent a = new Intent(easy_format_songs.this, hard_chooser.class);
                startActivity(a);

            }
        });
        dialog.show();

    }














    //calling of bars light
private void processg2(float pitch2) {
    pitch2 = (pitch2 / 350) + 30;

    String b = String.format("%.2f" ,pitch2);
    if ((pitch2 >= 39.20 && pitch2 < 39.70)) {
        //e2
        efnotepatern.setText("G#7");

    }


    else  if ((pitch2 >= 39 && pitch2 < 39.20)) {
        //e2
        efnotepatern.setText("G7");


    }
    else if ((pitch2 >= 38.75 && pitch2 < 39.00)) {
        //e2

        efnotepatern.setText("F#7");

    }


    else if ((pitch2 >= 38 && pitch2 < 38.75)) {
        //e2
        efnotepatern.setText("F7");


    }

    else if ((pitch2 >= 37.45 && pitch2 < 38)) {
        //e2
        efnotepatern.setText("E7");

    }
    else if ((pitch2 >= 37.10 && pitch2 < 37.45)) {
        //e2

        efnotepatern.setText("D#7");
    }
    else if ((pitch2 >= 37 && pitch2 < 37.10)) {
        //e2

        efnotepatern.setText("A#5");
    }

    else if ((pitch2 >= 36.40 && pitch2 < 37)) {
        //e2
        efnotepatern.setText("D7");

    }
    else if ((pitch2 >= 36.30 && pitch2 < 36.40)) {
        //e2


        efnotepatern.setText("C#7");


    }

    else if ((pitch2 >= 35.80 && pitch2 < 36.30)) {
        //e2

        efnotepatern.setText("C7");

    }
    else if ((pitch2 >= 35.50 && pitch2 < 35.80)) {
        //e2
        efnotepatern.setText("B6");


    }

    else if ((pitch2 >= 35.17 && pitch2 < 35.50)) {
        //e2
        efnotepatern.setText("A#6");

    }

    else if ((pitch2 >= 34.90 && pitch2 < 35.17)) {
        //e2
        efnotepatern.setText("A6");

    }
    else if ((pitch2 >= 34.70 && pitch2 < 34.90)) {
        //e2
        efnotepatern.setText("G#6");

    }

    else if ((pitch2 >= 34.30 && pitch2 < 34.70)) {
        //e2

        efnotepatern.setText("G6");


    }
    else if ((pitch2 >= 34.20 && pitch2 < 34.30)) {
        //e2
        efnotepatern.setText("F#6");

    }

    else if ((pitch2 >= 34.00 && pitch2 < 34.20)) {
        //e2
        efnotepatern.setText("F6");

    }
    else if ((pitch2 >= 33.75 && pitch2 < 34.00)) {
        //e2
        efnotepatern.setText("E6");

    }
    else if ((pitch2 >= 33.50 && pitch2 < 33.75)) {
        //e2
        efnotepatern.setText("D#6");

    }

    else if ((pitch2 >= 33.20 && pitch2 < 33.50)) {
        //e2
        efnotepatern.setText("D6");

    }
    else if ((pitch2 >= 33.10 && pitch2 < 33.20)) {
        //e2
        efnotepatern.setText("C#6");

    }

    else if ((pitch2 >= 32.90 && pitch2 < 33.10)) {
        //e2
        efnotepatern.setText("C6");

    }
    else if ((pitch2 >= 33.85 && pitch2 < 33.90)) {
        //e2
        efnotepatern.setText("B5");

    }
    else if ((pitch2 >= 32.82 && pitch2 < 33.85)) {
        //e2
        efnotepatern.setText("A#5");

    }
    else if ((pitch2 >= 32.72 && pitch2 < 32.82)) {
        //e2

        efnotepatern.setText("B5");

    }

    else if ((pitch2 >= 32.60 && pitch2 < 32.72)) {
        //e2
        efnotepatern.setText("A#5");


    }  else if ((pitch2 >= 32.42 && pitch2 < 32.60)) {
        //e2
        efnotepatern.setText("A5");

    }

    else if ((pitch2 >= 32.30 && pitch2 < 32.42)) {
        //e2

        efnotepatern.setText("D#7");
    }
    else if ((pitch2 >= 32.15 && pitch2 < 32.30)) {
        //e2
        efnotepatern.setText("D7");

    }

    else if ((pitch2 >= 32.00 && pitch2 < 32.15)) {
        //e2
        efnotepatern.setText("C#6");


    }

    else if ((pitch2 >= 31.80 && pitch2 < 32.00)) {
        //e2
        efnotepatern.setText("A5");

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






