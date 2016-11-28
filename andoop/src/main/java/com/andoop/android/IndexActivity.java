package com.andoop.android;

import android.app.Activity;
import android.os.Bundle;


import com.andoop.webexplor.AndoopExplor;
import com.andoop.webexplor.CustomWebView;
import com.andoop.webexplor.core.ExplorConfig;
import com.andoop.webexplor.listeners.DefaultWebEventListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class IndexActivity extends Activity{
    @InjectView(R.id.wv_index)
    CustomWebView customWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        ButterKnife.inject(this);
        init();
        customWebView.loadUrlForSelf("http://www.baidu.com");
    }

    private void init() {

        ExplorConfig config=new ExplorConfig.Builder()
                .openNew(false)
                .showMore(false)
                .build();
        AndoopExplor.getInstance().init(config);
        customWebView.setWebViewEventListener(new DefaultWebEventListener(this));
    }


}