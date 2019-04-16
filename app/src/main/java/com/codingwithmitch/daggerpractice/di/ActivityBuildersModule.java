package com.codingwithmitch.daggerpractice.di;

import com.codingwithmitch.daggerpractice.di.auth.AuthViewModelsModule;
import com.codingwithmitch.daggerpractice.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class})
    abstract AuthActivity contributeAuthActivity();

}
