package com.codingwithmitch.daggerpractice;


import com.codingwithmitch.daggerpractice.di.DaggerAppComponent;
import com.codingwithmitch.daggerpractice.di.SessionManager;


import javax.inject.Inject;

import dagger.android.AndroidInjector;

import dagger.android.support.DaggerApplication;


public class BaseApplication extends DaggerApplication {

    @Inject
    SessionManager sessionManager;

    @Override
    public AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }


}












