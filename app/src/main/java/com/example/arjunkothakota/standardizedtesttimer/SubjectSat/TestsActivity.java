package com.example.arjunkothakota.standardizedtesttimer.SubjectSat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.arjunkothakota.standardizedtesttimer.Home.HomePage;
import com.example.arjunkothakota.standardizedtesttimer.R;

public class TestsActivity extends AppCompatActivity {

    ListView testsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        String[] tests = {"Literature", "U.S. History", "World History", "Mathematics Level 1", "Mathematics Level 2", "Biology E/M", "Chemistry", "Physics", "French", "Spanish", "German", "Chinese", "Japanese", "Latin", "Modern Hebrew", "Italian"};

        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tests);
        testsListView = (ListView) findViewById(R.id.testListView);
        testsListView.setAdapter(listAdapter);

        testsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TestsActivity.this, SubjectSatActivity.class);
                intent.putExtra("testname", testsListView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(TestsActivity.this, HomePage.class);
        startActivity(intent);
    }
}