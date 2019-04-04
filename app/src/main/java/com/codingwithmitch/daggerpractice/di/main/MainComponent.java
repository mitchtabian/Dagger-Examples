package com.codingwithmitch.daggerpractice.di.main;


import com.codingwithmitch.daggerpractice.MainActivity;
import com.codingwithmitch.daggerpractice.di.login.LoginComponent;
import com.codingwithmitch.daggerpractice.ui.login.LoginActivity;
import com.codingwithmitch.daggerpractice.ui.login.User;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


@Singleton
@Subcomponent(modules = {
        MainActivityBuildersModule.class,
        MainViewModelsModule.class,
        AndroidInjectionModule.class
})
public interface MainComponent extends AndroidInjector<DaggerApplication>{

    // TODO? add PostComponent.Builder?
    // TODO? add TodoComponent.Builder?

    @Subcomponent.Builder
    interface Builder {

//        @BindsInstance
//        Builder user(User user);

        MainComponent build();


//        @BindsInstance
//        Builder activity(MainActivity mainActivity);

    }
}
