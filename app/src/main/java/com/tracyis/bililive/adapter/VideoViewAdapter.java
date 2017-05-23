package com.tracyis.bililive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import com.tracyis.bililive.ui.FragmentFactory;

/**
 * Created by Trasys on 2017/5/23.
 */
public class VideoViewAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "VideoViewAdapter";
    private String[] titles = {"互动","排行榜","舰队"};

    public VideoViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return ((Fragment)object).getView() == view;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getInstance().getFragment(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
