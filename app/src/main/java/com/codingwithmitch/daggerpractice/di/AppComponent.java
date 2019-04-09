package com.codingwithmitch.daggerpractice.di;


import android.app.Application;

import com.codingwithmitch.daggerpractice.BaseApplication;
import com.codingwithmitch.daggerpractice.ui.auth.AuthSessionComponent;
import com.codingwithmitch.daggerpractice.AuthSessionManager;
import com.codingwithmitch.daggerpractice.ui.main.MainComponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AndroidInjectionModule.class,
                AppModule.class,
                ActivityBuildersModule.class,
                ViewModelsModule.class,
        })
public interface AppComponent extends AndroidInjector<BaseApplication> {

    AuthSessionManager authSessionManager();

//    MainComponent.Builder mainBuilder();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}




















