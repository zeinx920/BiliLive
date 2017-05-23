package com.tracyis.bililive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import com.tracyis.bililive.ui.FragmentFactory;
import com.tracyis.bililive.ui.fragment.BaseFragment;

/**
 * Created by Trasys on 2017/5/23.
 */
public class VideoViewAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "VideoViewAdapter";
    private final int mRoom;
    private String[] titles = {"互动","排行榜","舰队"};

    public VideoViewAdapter(FragmentManager fm, int roomID) {
        super(fm);
        mRoom = roomID;
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
        BaseFragment fragment = FragmentFactory.getInstance().getFragment(position);
        fragment.setRoom(mRoom);
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
