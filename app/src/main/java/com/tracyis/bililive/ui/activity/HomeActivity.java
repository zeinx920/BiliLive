package com.tracyis.bililive.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.tracyis.bililive.R;
import com.tracyis.bililive.adapter.HomeGVAdapter;
import com.tracyis.bililive.bean.LiveBean;
import com.tracyis.bililive.bean.LiveCategoryBean;
import com.tracyis.bililive.network.MyRetroCallback;
import com.tracyis.bililive.network.MyRetrofit;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    @InjectView(R.id.tb_home)
    Toolbar mTbHome;
    @InjectView(R.id.gv_Home)
    GridView gvHome;

    private HashMap<Integer, List<String>> mLiveTopList = new HashMap<>();
    private String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);
        setSupportActionBar(mTbHome);

        init();
        requestData();
        initListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    private void requestData() {
        Call<LiveCategoryBean> categoryBeanCall = MyRetrofit
                .getInstance()
                .getApi()
                .getTopCategory();
        categoryBeanCall.enqueue(new MyRetroCallback<LiveCategoryBean>() {
            @Override
            protected void onSuccess(LiveCategoryBean data) {
                LiveCategoryBean datas = data;
                mLiveTopList.put(0, datas.data._$1);
                mLiveTopList.put(1, datas.data._$2);
                mLiveTopList.put(2, datas.data._$3);
                mLiveTopList.put(3, datas.data._$4);
                mLiveTopList.put(4, datas.data._$99);
                mLiveTopList.put(5, datas.data._$6);
                mLiveTopList.put(6, datas.data._$7);
                mLiveTopList.put(7, datas.data._$8);
                mLiveTopList.put(8, datas.data._$9);
                mLiveTopList.put(9, datas.data._$10);
                mLiveTopList.put(10, datas.data._$11);
                mLiveTopList.put(11, datas.data._$12);
            }

            @Override
            protected void onFail(String err) {
                Log.d(TAG, "onFail: " + err);
            }
        });
    }

    private void initListener() {
        gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                requestDetail(position);
            }
        });

    }

    private void requestDetail(final int position) {
        Call<LiveBean> categoryBeanCall = MyRetrofit
                .getInstance()
                .getApi()
                .getLiveList(position);
        categoryBeanCall.enqueue(new MyRetroCallback<LiveBean>() {
            @Override
            protected void onSuccess(LiveBean data) {
                Intent intent = new Intent(HomeActivity.this, LiveListActivity.class);
                intent.putExtra("liveBean", data);
                intent.putExtra("tb_title",items[position]);
                intent.putExtra("topList", (Serializable) mLiveTopList.get(position));
                Log.d(TAG, "onSuccess: " + mLiveTopList.get(position) + "");
                startActivity(intent);
            }

            @Override
            protected void onFail(String err) {
                Toast.makeText(HomeActivity.this, err, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void init() {
        items = getResources().getStringArray(R.array.live_category);

        HomeGVAdapter adapter = new HomeGVAdapter(this);
        gvHome.setAdapter(adapter);
    }
}
