package com.spark.zwanandroid.di.component;



import com.spark.zwanandroid.di.module.FragmentModule;
import com.spark.zwanandroid.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = ApplicationComponent.class)
public interface FragmentComponent {


    /*fragment注入*/
   //void inject(ShareFragment shareFragment);


}
