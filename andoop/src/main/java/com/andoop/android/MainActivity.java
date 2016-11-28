package com.andoop.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.andoop.android.login.Ologin;
import com.andoop.android.login.Olostfind;
import com.andoop.android.login.Osign;
import com.andoop.loginlib.AndoopLogin;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        AndoopLogin.getInstance(this).regist(IndexActivity.class,
                new Ologin(this),new Osign(this),new Olostfind(this));
    }
    @OnClick(R.id.bt_testlogin_main)
    public void clickEvent(View view){
        switch (view.getId()){
            case R.id.bt_testlogin_main:
                AndoopLogin.getInstance(this).show(this);
                break;
        }
    }
}
