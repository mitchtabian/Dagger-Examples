package com.codingwithmitch.daggerpractice;


import dagger.android.AndroidInjector;

import dagger.android.support.DaggerApplication;

import com.codingwithmitch.daggerpractice.di.DaggerAppComponent;

public class BaseApplication extends DaggerApplication {

    @Override
    public AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
//        return null;
    }


}












