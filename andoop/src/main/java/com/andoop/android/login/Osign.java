package com.andoop.android.login;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import com.andoop.android.model.AppUser;
import com.andoop.loginlib.listener.OutSignCallback;
import com.andoop.loginlib.outimp.IoutSign;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by domob on 2016/11/23.
 */

public class Osign implements IoutSign {
    private final Activity activity;

    public Osign(Activity activity) {
        this.activity=activity;
    }

    @Override
    public void onSign(final String name, final String password, final String phone, final String question, final OutSignCallback signCallback) {

        BmobQuery<AppUser> appUserBmobQuery = new BmobQuery<>();
        appUserBmobQuery
                .addWhereEqualTo("username",name);//保证用户名唯一

        appUserBmobQuery.findObjects(new FindListener<AppUser>() {
            @Override
            public void done(List<AppUser> list, BmobException e) {
                if(e!=null){
                    if(e.getErrorCode()==202){
                        signCallback.fail("用户已注册，请登陆！");
                    }else if(e.getErrorCode()==9016){
                        //网络错误
                        signCallback.fail("网络不给力");
                    }else {
                        signCallback.fail("注册失败:"+e.toString());
                    }
                    return;
                }
                if(list!=null&&list.size()>0){
                    //用户已经存在
                    signCallback.fail("用户已注册，请登陆！");
                }else {
                    //用户不存在
                    //创建用户
                    AppUser appUser = new AppUser();
                    appUser.setUsername(name);
                    appUser.setPassword(password);
                    appUser.setPhoneaut(false);
                    appUser.setPhonenumber(phone);
                    appUser.setAnswer(question);
                    //保存用户
                    appUser.save(new SaveListener<String>() {
                        @Override
                        public void done(String objid, BmobException e) {
                           Log.e("----->",objid+"");
                            if(e==null){
                                if(TextUtils.isEmpty(objid)){
                                    signCallback.fail("注册失败");
                                }else {
                                    signCallback.success();
                                }
                            }else {
                                if(e.getErrorCode()==202){
                                    signCallback.fail("用户已注册，请登陆！");
                                }else if(e.getErrorCode()==9016){
                                    //网络错误
                                    signCallback.fail("网络不给力");
                                }else {
                                    signCallback.fail("注册失败:"+e.getMessage());
                                }
                            }
                        }
                    });
                }

            }
        });

    }

    @Override
    public void onBack() {

    }

}
