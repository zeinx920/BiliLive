package com.tracyis.bililive.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tracyis.bililive.network.MyRetrofit;

/**
 * Created by Trasys on 2017/4/6.
 */

public class MyApp extends Application {
    private static final String TAG = "MyApp";
    private RefWatcher refWatcher;


    @Override
    public void onCreate() {
        super.onCreate();
        MyRetrofit.getInstance().init(getApplicationContext());

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        refWatcher= LeakCanary.install(this);
//        LeakCanary.install(this);
        // Normal app init code...
    }


//    public static RefWatcher getRefWatcher(Context context) {
//        MyApp application = (MyApp) context.getApplicationContext();
//        return application.refWatcher;
//    }

}

