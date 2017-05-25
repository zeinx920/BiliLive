package com.tracyis.bililive.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.tracyis.bililive.R;
import com.tracyis.bililive.adapter.VideoViewAdapter;
import com.tracyis.bililive.view.TabPageIndicator;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

public class VideoViewActivity extends AppCompatActivity {
    private static final String TAG = "VideoViewActivity";

    private IjkVideoView mVideoView;
    private boolean mBackPressed;
    private String mVideoPath;
    private ViewPager mVp;
    private TabPageIndicator mTpi;
    private int mRoomID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mTpi.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mVp.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        mVideoPath = getIntent().getStringExtra("stream_addr");
        mRoomID = getIntent().getIntExtra("room_id",0);
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        if (mVideoPath != null) {
            mVideoView.setVideoPath(mVideoPath);
       }
        mVideoView.start();

        mVp.setAdapter(new VideoViewAdapter(getSupportFragmentManager(),mRoomID));
        mTpi.setViewPager(mVp);
        mVp.setCurrentItem(0);
    }

    private void initView() {
        mVideoView = (IjkVideoView) findViewById(R.id.video_view);
        mVp = (ViewPager) findViewById(R.id.vp_vva);
        mTpi = (TabPageIndicator) findViewById(R.id.tpi_vva);
    }

    @Override
    public void onBackPressed() {
        mBackPressed = true;
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mBackPressed || !mVideoView.isBackgroundPlayEnabled()) {
            mVideoView.stopPlayback();
            mVideoView.release(true);
            mVideoView.stopBackgroundPlay();
        } else {
            mVideoView.enterBackground();
        }
        IjkMediaPlayer.native_profileEnd();

    }

}
