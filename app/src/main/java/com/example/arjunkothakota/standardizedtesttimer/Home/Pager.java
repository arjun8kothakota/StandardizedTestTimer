package com.example.arjunkothakota.standardizedtesttimer.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Arjun Kothakota on 11/3/2017.
 */

public class Pager extends FragmentStatePagerAdapter {

    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                SatFragment satFragment = new SatFragment();
                return satFragment;
            case 1:
                ActFragment actFragment = new ActFragment();
                return actFragment;
            case 2:
                SubjectFragment subjectFragment = new SubjectFragment();
                return subjectFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}