package com.tracyis.bililive.ui;

import android.util.Log;

import com.tracyis.bililive.ui.fragment.BaseFragment;
import com.tracyis.bililive.ui.fragment.InteractFragment;
import com.tracyis.bililive.ui.fragment.RankingFragment;
import com.tracyis.bililive.ui.fragment.ShipFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trasys on 2017/5/23.
 */
public class FragmentFactory {
    private static final String TAG = "FragmentFactory";
    private  static FragmentFactory sInstance;

    private FragmentFactory(){}

    public static FragmentFactory getInstance(){
        if(sInstance == null){
            sInstance = new FragmentFactory();
        }
        return sInstance;
    }

    // 创建一个map集合，保存position对应的 Fragment，作为缓存复用
    private  static Map<Integer,BaseFragment> mFragments =  new HashMap<>();

    // 提供获取fragment，根据position 返回Fragment
    // 问题，Fragment 在保存的时候，错误的页面为什么没有保存
    public BaseFragment getFragment(int position){
        // 如果之前集合中保存了当前 position 的Fragment，就直接返回
        if(mFragments.get(position)!= null){
            Log.e("FragmentFactory"," 从map中取出fragment是"+mFragments.get(position));
            return mFragments.get(position);
        }
        BaseFragment fragment;
        switch (position){
            case 0:
                fragment = new InteractFragment();
                break;
            case 1:
                fragment = new RankingFragment();
                break;
            case 2:
                fragment = new ShipFragment();
                break;
            default:
                fragment = new InteractFragment();
                break;
        }
        mFragments.put(position,fragment);
        Log.e(getClass().getSimpleName(),"HashMap存的页面是"+mFragments.get(position));
        return fragment;
    }

}
