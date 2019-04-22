package com.codingwithmitch.daggerpractice.di;

import com.codingwithmitch.daggerpractice.di.auth.AuthModule;
import com.codingwithmitch.daggerpractice.di.auth.AuthViewModelsModule;
import com.codingwithmitch.daggerpractice.ui.auth.AuthActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class})
    abstract AuthActivity contributeAuthActivity();

}
