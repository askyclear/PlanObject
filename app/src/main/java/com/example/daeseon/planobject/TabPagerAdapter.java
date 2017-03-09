package com.example.daeseon.planobject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by DaeSeon on 2017-03-07.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:

                FragmentFirstLife fragmentLife1 = new FragmentFirstLife();
                return fragmentLife1;
            case 1:
                FragmentSecondLife fragmentLife2 = new FragmentSecondLife();
                return fragmentLife2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
