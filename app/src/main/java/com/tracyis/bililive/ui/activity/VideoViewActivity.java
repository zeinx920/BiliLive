package com.tracyis.bililive.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tracyis.bililive.R;
import com.tracyis.bililive.adapter.VideoViewAdapter;
import com.tracyis.bililive.bean.DanmuBean;
import com.tracyis.bililive.network.MyRetroCallback;
import com.tracyis.bililive.network.MyRetrofit;
import com.tracyis.bililive.ui.fragment.InteractFragment;
import com.tracyis.bililive.view.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;
import retrofit2.Call;
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
    private DanmakuView mDanmakuView;
    private boolean mIsShowDanmaku;
    private DanmakuContext mDanmakuContext;
    private TextView mDanmuSwi;
    private int mRoom;
    private List<DanmuBean.DataBean.RoomBean> mRoomMes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        initView();
        initData();
        initListener();
        initDanmuView();
//        requestNet();
    }

    private BaseDanmakuParser parser = new BaseDanmakuParser() {
        @Override
        protected IDanmakus parse() {
            return new Danmakus();
        }
    };

    private void initDanmuView() {
        mDanmakuView.enableDanmakuDrawingCache(true);
        mDanmakuView.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                mIsShowDanmaku = true;
                mDanmakuView.start();
                generateSomeDanmaku();
            }

            @Override
            public void updateTimer(DanmakuTimer timer) {

            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {

            }

            @Override
            public void drawingFinished() {
            }
        });
        mDanmakuContext = DanmakuContext.create();
        mDanmakuView.prepare(parser, mDanmakuContext);
    }

    public void requestNet() {
        Call<DanmuBean> rankingBeanCall = MyRetrofit
                .getInstance()
                .getApi()
                .getDanmuList(mRoom);
        rankingBeanCall.enqueue(new MyRetroCallback<DanmuBean>() {
            @Override
            protected void onSuccess(DanmuBean data) {
                //巨坑!!
                // mRoomMes = data.data.room; 千万不要使用
                mRoomMes.addAll(data.data.room);
            }

        });
    }

    private InteractFragment.OnSendDanmuListener mOnSendDanmuListener = new InteractFragment.OnSendDanmuListener() {
        @Override
        public void sendAdminDanmu(String danmu) {
            addDanmaku(danmu, true);
        }
    };


    private void addDanmaku(String content, boolean withBorder) {
        BaseDanmaku danmaku = mDanmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        danmaku.text = content;
        danmaku.padding = 5;
        danmaku.textSize = sp2px(20);
        danmaku.textColor = Color.WHITE;
        danmaku.setTime(mDanmakuView.getCurrentTime());
        if (withBorder) {
            danmaku.borderColor = Color.GREEN;
        }
        mDanmakuView.addDanmaku(danmaku);
    }

    //测试弹幕
    private void generateSomeDanmaku() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mIsShowDanmaku) {
                    int time = new Random().nextInt(300);
                    String content = "" + time + time;
//                    for (int i = 0; i < mRoomMes.size(); i++) {
//                        String text = mRoomMes.get(i).text;
//                        addDanmaku(text, false);
//                    }
                    addDanmaku(content,false);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //sp转px
    public int sp2px(float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
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
        mDanmuSwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mIsShowDanmaku = !mIsShowDanmaku;
                Log.d(TAG, "onClick: 弹幕开关 " + mIsShowDanmaku);
            }
        });
    }

    private void initData() {
        mVideoPath = getIntent().getStringExtra("stream_addr");
        mRoomID = getIntent().getIntExtra("room_id", 0);
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        if (mVideoPath != null) {
            Log.d(TAG, "initData: " + mVideoPath);
            mVideoView.setVideoPath(mVideoPath);
        }
        mVideoView.start();
        VideoViewAdapter videoViewAdapter = new VideoViewAdapter(getSupportFragmentManager(), mRoomID);

        //用户发弹幕
        InteractFragment item = (InteractFragment) videoViewAdapter.getItem(0);
        item.setOnSendDanmuListener(mOnSendDanmuListener);

        mVp.setAdapter(videoViewAdapter);
        mVp.setCurrentItem(0);
        mVp.setOffscreenPageLimit(0);
        mTpi.setViewPager(mVp);
    }

    private void initView() {
        mVideoView = (IjkVideoView) findViewById(R.id.video_view);
        mVp = (ViewPager) findViewById(R.id.vp_vva);
        mTpi = (TabPageIndicator) findViewById(R.id.tpi_vva);
        mDanmakuView = (DanmakuView) findViewById(R.id.view_danmu);
        mDanmuSwi = (TextView) findViewById(R.id.tv_danmu_swi);
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
