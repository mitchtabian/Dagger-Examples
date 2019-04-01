package com.codingwithmitch.daggerpractice.di.component;

import android.app.Application;

import com.codingwithmitch.daggerpractice.BaseApplication;
import com.codingwithmitch.daggerpractice.di.module.ViewModelModule;
import com.codingwithmitch.daggerpractice.di.module.ActivityBindingModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        ViewModelModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}