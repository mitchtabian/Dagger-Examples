package com.codingwithmitch.daggerpractice.di;

import android.app.Application;


import javax.inject.Singleton;


import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        MainActivityModule.class,
        MainViewModelsModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }
}