package com.spark.zwanandroid.di.component;


import com.spark.zwanandroid.di.module.ApplicationModule;
import com.spark.zwanandroid.model.DataManager;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * desc:
 *
 * @author Bian
 * create at 2018/12/14 15:19
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();

    /**
     * OkHttp
     *
     * @return Builder
     */
    OkHttpClient.Builder getOkHttpClient();
}
