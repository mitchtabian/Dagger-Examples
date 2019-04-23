package com.codingwithmitch.daggerpractice.di;

import com.codingwithmitch.daggerpractice.di.auth.AuthModule;
import com.codingwithmitch.daggerpractice.di.auth.AuthViewModelsModule;
import com.codingwithmitch.daggerpractice.di.main.MainFragmentBuildersModule;
import com.codingwithmitch.daggerpractice.di.main.MainViewModelsModule;
import com.codingwithmitch.daggerpractice.ui.auth.AuthActivity;
import com.codingwithmitch.daggerpractice.ui.main.MainActivity;

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


    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class}
    )
    abstract MainActivity contributeMainActivity();

}
