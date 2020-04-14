package com.spark.zwanandroid.di.component;


import com.spark.zwanandroid.MainActivity;
import com.spark.zwanandroid.di.module.ActivityModule;
import com.spark.zwanandroid.di.scope.ActivityScope;
import com.spark.zwanandroid.ui.login.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {


    /*activity注入 */
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);

}
