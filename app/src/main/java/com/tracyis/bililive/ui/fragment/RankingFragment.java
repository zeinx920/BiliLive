package com.tracyis.bililive.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tracyis.bililive.R;

/**
 * Created by Trasys on 2017/5/23.
 */
public class RankingFragment extends Fragment {
    private static final String TAG = "InteractFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_interact, null);
        return view;
    }
}
