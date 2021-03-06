package app.sematech.training.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
            return FragmentA.getInstance();
        if (position==1)
            return FragmentB.getInstance();
        if (position==2)
            return FragmentC.getInstance();
        if (position==3)
            return FragmentD.getInstance();
        if (position==4)
            return FragmentE.getInstance();
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
            return "Frag 0";
        if (position==1)
            return "Frag 1";
        if (position==2)
            return "Frag 2";
        if (position==3)
            return "Frag 3";
        if (position==4)
            return "Frag 4";
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
