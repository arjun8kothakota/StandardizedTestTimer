package com.example.arjunkothakota.standardizedtesttimer.Home;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.arjunkothakota.standardizedtesttimer.R;
import com.example.arjunkothakota.standardizedtesttimer.SubjectSat.TestsActivity;

public class SubjectFragment extends Fragment {

    ImageButton subjectSatBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_subject, container, false);

        subjectSatBtn = (ImageButton) view.findViewById(R.id.subjectSatBtn);

        subjectSatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TestsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}