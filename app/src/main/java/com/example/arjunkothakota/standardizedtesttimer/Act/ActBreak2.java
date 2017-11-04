package com.example.arjunkothakota.standardizedtesttimer.Act;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.arjunkothakota.standardizedtesttimer.R;

import java.util.concurrent.TimeUnit;

public class ActBreak2 extends AppCompatActivity {

    TextView timeTxt, continueBtn, textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_break2);

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


                String hms = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                timeTxt.setText(hms);
            }

            @Override
            public void onFinish() {

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
}
