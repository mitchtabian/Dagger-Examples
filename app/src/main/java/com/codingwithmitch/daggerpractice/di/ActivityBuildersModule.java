package com.codingwithmitch.daggerpractice.di;


import com.codingwithmitch.daggerpractice.di.session.SessionScope;
import com.codingwithmitch.daggerpractice.ui.auth.AuthModule;
import com.codingwithmitch.daggerpractice.ui.auth.AuthActivity;
import com.codingwithmitch.daggerpractice.ui.main.MainActivity;
import com.codingwithmitch.daggerpractice.ui.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @SessionScope
    @ContributesAndroidInjector(
            modules = {MainModule.class})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(
            modules = {AuthModule.class, ViewModelsModule.class})
    abstract AuthActivity contributeAuthActivity();

}
