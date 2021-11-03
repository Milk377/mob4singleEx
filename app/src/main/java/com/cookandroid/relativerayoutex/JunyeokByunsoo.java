package com.cookandroid.relativerayoutex;

import android.app.Application;

public class JunyeokByunsoo extends Application {

    private Boolean loginOrNot;
    private String userId;
    private String userPass;
    private String userName;
    private String userPhone;
    private String userAddress;

    @Override
    public void onCreate() {
        loginOrNot = false;
        userId = "";
        userPass = "";
        userName = "";
        userPhone ="";
        userAddress = "";

        super.onCreate();
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
    }


    public Boolean getloginOrNot(){
    return loginOrNot;
    };

    public String getuserId() {
        return userId;
    };

    public String getuserPass(){
        return userPass;
    };
    public String getuserName(){
        return userName;
    };
    public String getuserPhone(){
        return userPhone;
    };
    public String getuserAddress(){
        return userAddress;
    };

    public void setloginOrNot(Boolean _val){
        loginOrNot = _val;
    };

    public void setuserId(String _val){
        userId = _val;
    };

    public void setuserPass(String _val){
        userPass = _val;
    };

    public void setuserName(String _val){
        userName = _val;
    };

    public void setuserPhone(String _val){
        userPhone = _val;
    };

    public void setuserAddress(String _val){
        userAddress = _val;
    };

}
