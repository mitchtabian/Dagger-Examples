package com.codingwithmitch.daggerpractice.di.login;

import com.codingwithmitch.daggerpractice.di.ActivityScope;
import com.codingwithmitch.daggerpractice.ui.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class LoginActivityBuildersModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract LoginActivity contributeLoginActivity();
}
