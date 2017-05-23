package com.tracyis.bililive.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tracyis.bililive.R;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

public class VideoViewActivity extends AppCompatActivity {
    private IjkVideoView mVideoView;
    private boolean mBackPressed;
    private String mVideoPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        mVideoPath = getIntent().getStringExtra("stream_addr");
        mVideoView = (IjkVideoView) findViewById(R.id.video_view);
        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        if (mVideoPath != null) {
            mVideoView.setVideoPath(mVideoPath);
        }
        mVideoView.start();
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
