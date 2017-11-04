package com.example.arjunkothakota.standardizedtesttimer.SubjectSat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.arjunkothakota.standardizedtesttimer.R;

public class TestsActivity extends AppCompatActivity {

    ListView testsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        String[] tests = {"Math Level 1", "Math Level 2", "Physics", "Chemistry", "Literature", "History", "World History", "Biology", "Chinese", "French", "German", "Modern Hebrew", "Italian", "Japanese", "Korean", "Latin", "Spanish"};

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
}