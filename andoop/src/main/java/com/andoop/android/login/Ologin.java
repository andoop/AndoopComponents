package com.andoop.android.login;

import android.app.Activity;
import android.util.Log;

import com.andoop.android.model.AppUser;
import com.andoop.loginlib.listener.OutLoginCallback;
import com.andoop.loginlib.outimp.IoutLogin;


import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by domob on 2016/11/23.
 */

public class Ologin implements IoutLogin {
    private final Activity activity;

    public Ologin(Activity activity) {
        this.activity=activity;
    }

    @Override
    public void onLogin(String name, String password, final OutLoginCallback loginCallback) {
        BmobQuery<AppUser> appUserBmobQuery = new BmobQuery<>();
        appUserBmobQuery.addWhereEqualTo("username",name);
        appUserBmobQuery.addWhereEqualTo("password",password);
        appUserBmobQuery.findObjects(new FindListener<AppUser>() {
            @Override
            public void done(List<AppUser> list, BmobException e) {
                if(e!=null){
                    switch (e.getErrorCode()){
                        case 101:
                            loginCallback.notRegist();
                            break;
                        case 9016:
                            loginCallback.onFail("网络不给力");
                            break;
                        default:
                            loginCallback.onFail("登陆失败");
                    }
                    return;
                }
                if(list!=null&&list.size()>0){
                    AppUser appUser = list.get(0);
                    //TODO:保存用户信息
                    Log.e("---->", "done: "+appUser.getUsername());
                    loginCallback.success();
                }else {
                    loginCallback.notRegist();
                    return;
                }

            }
        });
    }

    @Override
    public void onToLostFind() {

    }

    @Override
    public void onToSign() {

    }
}
