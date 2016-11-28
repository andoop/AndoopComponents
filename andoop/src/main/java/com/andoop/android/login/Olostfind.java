package com.andoop.android.login;

import android.app.Activity;

import com.andoop.android.model.AppUser;
import com.andoop.loginlib.listener.OutLostFindCallback;
import com.andoop.loginlib.outimp.IoutLostFind;


import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by domob on 2016/11/23.
 */

public class Olostfind implements IoutLostFind {
    private final Activity activity;

    public Olostfind(Activity activity) {
        this.activity=activity;
    }

    @Override
    public void onFind(String name, String phone, String question, final OutLostFindCallback lostFindCallback) {
        BmobQuery<AppUser> appUserBmobQuery = new BmobQuery<>();
        appUserBmobQuery
                .addWhereEqualTo("username",name)
                .addWhereEqualTo("phonenumber",phone)
                .addWhereEqualTo("answer",question);
        appUserBmobQuery.findObjects(new FindListener<AppUser>() {
            @Override
            public void done(List<AppUser> list, BmobException e) {
                if(e!=null){
                    if(e.getErrorCode()==9016){
                        //网络错误
                        lostFindCallback.fail("网络不给力");
                    }else {
                        lostFindCallback.fail("找回失败:"+e.toString());
                    }
                    return;
                }
                if(list!=null&&list.size()==1){
                    lostFindCallback.success(list.get(0).getPassword());
                }else {
                    lostFindCallback.fail("找回失败！");
                }
            }
        });
    }

    @Override
    public void onBack() {

    }
}
