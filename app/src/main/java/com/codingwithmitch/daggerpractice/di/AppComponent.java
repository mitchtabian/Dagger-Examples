package com.codingwithmitch.daggerpractice.di;


import android.app.Application;

import com.codingwithmitch.daggerpractice.BaseApplication;
import com.codingwithmitch.daggerpractice.di.session.SessionComponent;

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

    SessionComponent.Builder sessionBuilder();

    SessionManager sessionManager();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}




















