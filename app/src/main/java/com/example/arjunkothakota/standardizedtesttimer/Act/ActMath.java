package com.example.arjunkothakota.standardizedtesttimer.Act;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.arjunkothakota.standardizedtesttimer.R;

import java.util.concurrent.TimeUnit;
import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class ActMath extends AppCompatActivity {

    TextView timeTxt, textView, nextButton;
    Button startButton;
    ToggleButton stopButton;
    RingProgressBar progressBar;

    private boolean isCancelled = false;
    private boolean isPaused = false;
    private long remainingTime = 0;
    private int startClickCount;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_math);

        timeTxt = (TextView) findViewById(R.id.timeTxt);
        textView = (TextView) findViewById(R.id.textView7);
        startButton = (Button) findViewById(R.id.startButton);
        nextButton = (TextView) findViewById(R.id.nextButton);
        stopButton = (ToggleButton) findViewById(R.id.stopButton);
        progressBar = (RingProgressBar) findViewById(R.id.progressBar);

        progressBar.setProgress(0);

        final String string = getIntent().getStringExtra("noessay");
        textView.setText(string);
        textView.setVisibility(View.INVISIBLE);

        timeTxt.setText("60:00");

        stopButton.setEnabled(false);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startClickCount++;
                if (startClickCount % 2 == 1) {
                    startButton.setText("Restart");
                    stopButton.setEnabled(true);
                }

                isPaused = false;
                isCancelled = false;

                final long millisInFuture = 3600000;
                long countDownInterval = 1000;
                new CountDownTimer(millisInFuture, countDownInterval) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if (startClickCount % 2 == 0) {
                            startButton.setText("Start");
                            stopButton.setEnabled(false);
                            stopButton.setChecked(false);
                            isCancelled = true;
                            progressBar.setProgress(0);
                            i = 0;
                            start();
                        }
                        if (isCancelled) {
                            timeTxt.setText("60:00");
                            cancel();
                        } else if (isPaused || isCancelled) {
                            cancel();
                        } else {
                            i++;
                            String hms = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                            timeTxt.setText(hms);
                            int progress = (i*100/(3600000/1000));
                            progressBar.setProgress(progress);
                            remainingTime = millisUntilFinished;
                        }
                    }

                    @Override
                    public void onFinish() {
                        timeTxt.setText("Section Finished!");
                        progressBar.setProgress(100);
                        playAlarm();
                    }
                }.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stopButton.isChecked()) {
                    isPaused = true;
                    if (startClickCount % 2 == 1) {
                        startButton.setText("Restart");
                        stopButton.setEnabled(true);
                    }
                } else {
                    isPaused = false;

                    final long millisInFuture = remainingTime - 1000;
                    long countDownInterval = 1000;
                    new CountDownTimer(millisInFuture, countDownInterval) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            if (startClickCount % 2 == 0) {
                                startButton.setText("Start");
                                stopButton.setEnabled(false);
                                isCancelled = true;
                                start();
                            }
                            if (isCancelled) {
                                timeTxt.setText("60:00");
                                cancel();
                            } else if (isPaused || isCancelled) {
                                cancel();
                            } else {
                                i++;
                                String hms = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                                timeTxt.setText(hms);
                                int progress = (i*100/(3600000/1000));
                                progressBar.setProgress(progress);
                                remainingTime = millisUntilFinished;
                            }
                        }

                        @Override
                        public void onFinish() {
                            timeTxt.setText("Section Finished!");
                            progressBar.setProgress(100);
                            playAlarm();
                        }
                    }.start();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ActMath.this);
                alertDialogBuilder
                        .setMessage("Are you sure you want to move to the next section?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (textView.getText() == "") {
                                    Intent intent = new Intent(ActMath.this, ActReading.class);
                                    startActivity(intent);
                                }else {
                                    Intent intent = new Intent(ActMath.this, ActReading.class);
                                    intent.putExtra("noessay", string);
                                    startActivity(intent);
                                }
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    public void playAlarm(){

        final MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.wdta);

        mediaPlayer.start();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ActMath.this);
        alertDialogBuilder
                .setMessage("Time's Up!")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mediaPlayer.stop();
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}