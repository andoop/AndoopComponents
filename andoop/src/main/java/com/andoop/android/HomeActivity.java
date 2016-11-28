package com.andoop.android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.andoop.andooptabframe.AndoopFrameListener;
import com.andoop.andooptabframe.AndoopPage;
import com.andoop.andooptabframe.AndoopTabFrame;
import com.andoop.andooptabframe.core.AndoopFrame;
import com.andoop.andooptabframe.core.TabFrameConfig;
import com.andoop.android.pages.HomePage;

public class HomeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TabFrameConfig config = new TabFrameConfig.Builder()
                .setCacheCount(2)
                .canScroll(false)

                .tabColorString("#ff0000")
                .build();
        AndoopTabFrame.getInstance().init(config);
        AndoopTabFrame.getInstance().build(this, R.id.fl_home_layout, new AndoopFrameListener() {
            @Override
            public void onReady(AndoopFrame andoopFrame) {
                andoopFrame.addPage(new HomePage(), R.drawable.tabselector, "首页")
                        .addPage(new HomePage(), R.drawable.tabselector, "首页")
                        .addPage(new HomePage(), R.drawable.tabselector, "首页")
                        .commit();
            }
            @Override
            public void onSelect(AndoopPage andoopPage, int pos) {
                Toast.makeText(HomeActivity.this, "p" + pos, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
