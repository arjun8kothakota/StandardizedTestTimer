package com.example.arjunkothakota.standardizedtesttimer.Act;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.arjunkothakota.standardizedtesttimer.Home.HomePage;
import com.example.arjunkothakota.standardizedtesttimer.R;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ActBreak2 extends AppCompatActivity {

    TextView timeTxt, continueBtn, textView;

    private boolean isPaused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_break2);

        isPaused = false;

        timeTxt = (TextView) findViewById(R.id.timeTxt);
        continueBtn = (TextView) findViewById(R.id.continueBtn);
        textView = (TextView) findViewById(R.id.textView);

        final String string = getIntent().getStringExtra("noessay");
        textView.setText(string);
        textView.setVisibility(View.INVISIBLE);

        final long millisInFuture = 300000;
        long countDownInterval = 1000;

        new CountDownTimer(millisInFuture, countDownInterval){

            @Override
            public void onTick(long millisUntilFinished) {

                if (isPaused == true){
                    cancel();
                }

                String hms = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                timeTxt.setText(hms);
            }

            @Override
            public void onFinish() {
                final MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.alarmsound);
                mediaPlayer.start();
                if (textView.getText() == "") {
                    Intent intent = new Intent(ActBreak2.this, ActReading.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(ActBreak2.this, ActReading.class);
                    intent.putExtra("noessay", string);
                    startActivity(intent);
                }

                final Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg){
                        mediaPlayer.stop();
                    }
                };
//Task for timer to execute when time expires
                class SleepTask extends TimerTask {
                    @Override
                    public void run(){
                        handler.sendEmptyMessage(0);
                    }
                }

                Timer timer = new Timer("timer",true);
                timer.schedule(new SleepTask(),3000);
            }
        }.start();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ActBreak2.this);
                alertDialogBuilder
                        .setMessage("Are you sure you want to continue?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                isPaused = true;
                                if (textView.getText() == "") {
                                    Intent intent = new Intent(ActBreak2.this, ActWriting.class);
                                    startActivity(intent);
                                }else {
                                    Intent intent = new Intent(ActBreak2.this, ActWriting.class);
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

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ActBreak2.this);
        alertDialogBuilder
                .setMessage("Do you want to quit the test?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        isPaused = true;
                        Intent intent = new Intent(ActBreak2.this, HomePage.class);
                        startActivity(intent);
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
}