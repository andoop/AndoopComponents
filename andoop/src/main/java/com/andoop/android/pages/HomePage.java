package com.andoop.android.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andoop.andooptabframe.AndoopPage;
import com.andoop.android.R;

/**
 * Created by domob on 2016/11/25.
 */

public class HomePage extends BasePage {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        return view;
    }

    @Override
    public void onSelect(AndoopPage andoopPage, int pos) {
        Log.e("9999","dd"+pos);
    }
}
