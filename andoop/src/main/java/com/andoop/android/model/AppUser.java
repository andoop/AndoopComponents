package com.andoop.android.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by domob on 2016/11/23.
 */

public class AppUser extends BmobObject{
    String password;
    String username;
    Boolean phoneaut;
    String phonenumber;
    String answer;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Boolean getPhoneaut() {
        return phoneaut;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAnswer() {
        return answer;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneaut(Boolean phoneaut) {
        this.phoneaut = phoneaut;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
