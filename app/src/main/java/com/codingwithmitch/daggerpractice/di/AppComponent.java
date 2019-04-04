package com.codingwithmitch.daggerpractice.di;

import android.app.Application;


import com.codingwithmitch.daggerpractice.di.login.LoginComponent;
import com.codingwithmitch.daggerpractice.di.main.MainActivityBuildersModule;
import com.codingwithmitch.daggerpractice.di.main.MainComponent;
import com.codingwithmitch.daggerpractice.di.main.MainViewModelsModule;
import com.codingwithmitch.daggerpractice.ui.main.AuthManager;

import javax.inject.Singleton;


import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


//@Singleton
//@Component(modules = {
//        AppModule.class,
//        AndroidInjectionModule.class,
//        MainActivityBuildersModule.class,
//        MainViewModelsModule.class
//})
@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {


    LoginComponent.Builder loginBuilder();
//    MainComponent.Builder mainBuilder();

//    AuthManager getAuthManager();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }
}