package com.codingwithmitch.daggerpractice.di.login;


import com.codingwithmitch.daggerpractice.di.ActivityScope;
import com.codingwithmitch.daggerpractice.network.users.UsersApi;
import com.codingwithmitch.daggerpractice.ui.login.LoginActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerActivity;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.DaggerApplication;


@Subcomponent(
        modules = {
                LoginActivityBuildersModule.class,
                LoginViewModelsModule.class,
//        AndroidInjection.class
//        AndroidSupportInjection.class
})
//public interface LoginComponent extends AndroidInjector<DaggerAppCompatActivity> {
public interface LoginComponent  {

//    LoginActivity inject(LoginActivity loginActivity);

    @Subcomponent.Builder
    interface Builder {

        LoginComponent build();

//        @BindsInstance
//        Builder loginActivity(LoginActivity homeActivity);
    }

}










