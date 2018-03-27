package com.example.arjunkothakota.standardizedtesttimer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.arjunkothakota.standardizedtesttimer.Act.ActEnglish;
import com.example.arjunkothakota.standardizedtesttimer.Sat.ReadingActivity;
import com.example.arjunkothakota.standardizedtesttimer.SubjectSat.TestsActivity;

import org.w3c.dom.Text;

public class PreviewActivity extends AppCompatActivity {

    Button essayButton, noEssayButton;
    TextView startButton, section1, section1Time, section2, section2Time, section3, section3Time, section4, section4Time, section5, section5Time, satOrAct;
    public RelativeLayout layout;

    String a = "invisible";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        essayButton = (Button) findViewById(R.id.essayButton);
        noEssayButton = (Button) findViewById(R.id.noEssayButton);

        section1 = (TextView) findViewById(R.id.section1);
        section1Time = (TextView) findViewById(R.id.section1Time);
        section2 = (TextView) findViewById(R.id.section2);
        section2Time = (TextView) findViewById(R.id.section2Time);
        section3 = (TextView) findViewById(R.id.section3);
        section3Time = (TextView) findViewById(R.id.section3Time);
        section4 = (TextView) findViewById(R.id.section4);
        section4Time = (TextView) findViewById(R.id.section4Time);
        section5 = (TextView) findViewById(R.id.section5);
        section5Time = (TextView) findViewById(R.id.section5Time);
        satOrAct = (TextView) findViewById(R.id.sat);
        startButton = (TextView) findViewById(R.id.startButton);
        final TextView textView =(TextView) findViewById(R.id.textView5);
        final TextView textView1 = (TextView) findViewById(R.id.textView4);

        layout = (RelativeLayout) findViewById(R.id.layout);

        startButton.setVisibility(View.INVISIBLE);

        section1.setVisibility(View.INVISIBLE);
        section2.setVisibility(View.INVISIBLE);
        section3.setVisibility(View.INVISIBLE);
        section3.setVisibility(View.INVISIBLE);
        section4.setVisibility(View.INVISIBLE);
        section5.setVisibility(View.INVISIBLE);

        section1Time.setVisibility(View.INVISIBLE);
        section2Time.setVisibility(View.INVISIBLE);
        section3Time.setVisibility(View.INVISIBLE);
        section4Time.setVisibility(View.INVISIBLE);
        section5Time.setVisibility(View.INVISIBLE);

        satOrAct.setVisibility(View.INVISIBLE);

        String string = getIntent().getStringExtra("sat");
        textView1.setText(string);

        if (textView1.getText() == string){

            essayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    essayButton.setVisibility(View.INVISIBLE);
                    noEssayButton.setVisibility(View.INVISIBLE);
                    startButton.setVisibility(View.VISIBLE);

                    section1.setVisibility(View.VISIBLE);
                    section2.setVisibility(View.VISIBLE);
                    section3.setVisibility(View.VISIBLE);
                    section3.setVisibility(View.VISIBLE);
                    section4.setVisibility(View.VISIBLE);
                    section5.setVisibility(View.VISIBLE);

                    section1Time.setVisibility(View.VISIBLE);
                    section2Time.setVisibility(View.VISIBLE);
                    section3Time.setVisibility(View.VISIBLE);
                    section4Time.setVisibility(View.VISIBLE);
                    section5Time.setVisibility(View.VISIBLE);

                    satOrAct.setVisibility(View.VISIBLE);
                }
            });

            noEssayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    essayButton.setVisibility(View.INVISIBLE);
                    noEssayButton.setVisibility(View.INVISIBLE);
                    startButton.setVisibility(View.VISIBLE);
                    textView.setText(a);

                    section1.setVisibility(View.VISIBLE);
                    section2.setVisibility(View.VISIBLE);
                    section3.setVisibility(View.VISIBLE);
                    section3.setVisibility(View.VISIBLE);
                    section4.setVisibility(View.VISIBLE);

                    section1Time.setVisibility(View.VISIBLE);
                    section2Time.setVisibility(View.VISIBLE);
                    section3Time.setVisibility(View.VISIBLE);
                    section4Time.setVisibility(View.VISIBLE);

                    satOrAct.setVisibility(View.VISIBLE);
                }
            });

            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (textView.getText() == a){
                        Intent newintent = new Intent(PreviewActivity.this, ReadingActivity.class);
                        newintent.putExtra("noessay", a);
                        startActivity(newintent);
                    }else {
                        Intent intent = new Intent(PreviewActivity.this, ReadingActivity.class);
                        startActivity(intent);
                    }
                }
            });

        }else if (textView1.getText() == ""){

            essayButton.setBackgroundColor(Color.parseColor("#47cbad"));
            noEssayButton.setBackgroundColor(Color.parseColor("#47cbad"));
            startButton.setBackgroundColor(Color.parseColor("#47cbad"));
            satOrAct.setBackgroundColor(Color.parseColor("#47cbad"));
            section1.setBackgroundColor(Color.parseColor("#47cbad"));
            section2.setBackgroundColor(Color.parseColor("#47cbad"));
            section3.setBackgroundColor(Color.parseColor("#47cbad"));
            section4.setBackgroundColor(Color.parseColor("#47cbad"));
            section5.setBackgroundColor(Color.parseColor("#47cbad"));

            section1.setText("English");
            section2.setText("Math");
            section3.setText("Reading");
            section4.setText("Science");
            section5.setText("Writing");

            section1Time.setText("45 min");
            section2Time.setText("60 min");
            section3Time.setText("35 min");
            section4Time.setText("35 min");
            section5Time.setText("40 min");

            essayButton.setText("With Writing");
            noEssayButton.setText("Without Writing");


            essayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    essayButton.setVisibility(View.INVISIBLE);
                    noEssayButton.setVisibility(View.INVISIBLE);
                    startButton.setVisibility(View.VISIBLE);

                    section1.setVisibility(View.VISIBLE);
                    section2.setVisibility(View.VISIBLE);
                    section3.setVisibility(View.VISIBLE);
                    section3.setVisibility(View.VISIBLE);
                    section4.setVisibility(View.VISIBLE);
                    section5.setVisibility(View.VISIBLE);

                    section1Time.setVisibility(View.VISIBLE);
                    section2Time.setVisibility(View.VISIBLE);
                    section3Time.setVisibility(View.VISIBLE);
                    section4Time.setVisibility(View.VISIBLE);
                    section5Time.setVisibility(View.VISIBLE);

                    satOrAct.setVisibility(View.VISIBLE);
                }
            });

            noEssayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    essayButton.setVisibility(View.INVISIBLE);
                    noEssayButton.setVisibility(View.INVISIBLE);
                    startButton.setVisibility(View.VISIBLE);
                    textView.setText(a);

                    section1.setVisibility(View.VISIBLE);
                    section2.setVisibility(View.VISIBLE);
                    section3.setVisibility(View.VISIBLE);
                    section3.setVisibility(View.VISIBLE);
                    section4.setVisibility(View.VISIBLE);

                    section1Time.setVisibility(View.VISIBLE);
                    section2Time.setVisibility(View.VISIBLE);
                    section3Time.setVisibility(View.VISIBLE);
                    section4Time.setVisibility(View.VISIBLE);

                    satOrAct.setVisibility(View.VISIBLE);
                }
            });

            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (textView.getText() == a){
                        Intent newintent = new Intent(PreviewActivity.this, ActEnglish.class);
                        newintent.putExtra("noessay", a);
                        startActivity(newintent);
                    }else {
                        Intent intent = new Intent(PreviewActivity.this, ActEnglish.class);
                        startActivity(intent);
                    }
                }
            });

        }
    }
}