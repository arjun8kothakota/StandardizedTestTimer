package com.example.arjunkothakota.standardizedtesttimer.Home;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.arjunkothakota.standardizedtesttimer.PreviewActivity;
import com.example.arjunkothakota.standardizedtesttimer.R;

public class SatFragment extends Fragment{

    ImageButton satBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sat, container, false);

        satBtn = (ImageButton) view.findViewById(R.id.satBtn);

        satBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PreviewActivity.class);
                intent.putExtra("sat", "a");
                startActivity(intent);
            }
        });

        return view;
    }
}