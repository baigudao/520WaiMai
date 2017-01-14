package com.jackie.waimai.application;

import android.app.Application;

/**
 * Created by Administrator on 2016/11/3.
 */
public class JackieApplication extends Application {

    public static boolean SKIP_WELCOME;

    @Override
    public void onCreate() {
        SKIP_WELCOME = false;
        super.onCreate();
    }
}
