package com.codingwithmitch.daggerpractice.di;


import android.app.Application;

import com.codingwithmitch.daggerpractice.BaseApplication;
import com.codingwithmitch.daggerpractice.SessionManager;
import com.codingwithmitch.daggerpractice.di.auth.AuthActivitySubcomponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AppModule.class,
                ActivityBuildersModule.class,
                ViewModelFactoryModule.class,
        })
public interface AppComponent extends AndroidInjector<BaseApplication> {

    SessionManager sessionManager();

    AuthActivitySubcomponent.Factory authSubcomponent();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}




















