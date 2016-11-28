package com.andoop.android;

import android.app.Application;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;


/* * * * * * * * * * * * * * * * * * *
* author :andoop　　　　　　　　　　　
* time   :2016/11/22
* explain：
* * * * * * * * * * * * * * * * * * */
public class AndoopApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BmobConfig.Builder builder = new BmobConfig.Builder(this);
        builder.setApplicationId("7458b47583f4d1a5f2d65491ccf184eb");
        builder.setConnectTimeout(15000);
        Bmob.initialize(builder.build());
    }
}
