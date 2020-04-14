package com.spark.zwanandroid.model.sp;

import android.content.Context;
import android.content.SharedPreferences;


import com.spark.zwanandroid.di.qualifier.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class PreferencesHelper implements IPreferencesHelper {

    private SharedPreferences mPreferences;

    @Inject
    PreferencesHelper(@ApplicationContext Context context) {
        //mPreferences = BaseApp.getInstance().getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void setLoginAccount(String account) {
       // mPreferences.edit().putString(Constants.SP_ACCOUNT, account).apply();
    }

    @Override
    public void setLoginPassword(String password) {
       // mPreferences.edit().putString(Constants.SP_PASSWORD, password).apply();
    }

    @Override
    public void setUserToken(String token) {
        //mPreferences.edit().putString(Constants.SP_TOKEN, token).apply();
    }

    @Override
    public void setSpeechOpenStatus(boolean flag) {
       // mPreferences.edit().putBoolean(Constants.SP_SPEECH, flag).apply();
    }

    @Override
    public String getLoginAccount() {

        //mPreferences.getString(Constants.SP_ACCOUNT, "");
        return "";
    }

    @Override
    public String getLoginPassword() {
        //mPreferences.getString(Constants.SP_PASSWORD, "");
        return "";
    }

    @Override
    public String getUserToken() {
        //mPreferences.getString(Constants.SP_TOKEN, "")
        return "";
    }

}
