package com.codingwithmitch.daggerpractice.di;

import com.codingwithmitch.daggerpractice.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = {MainFragmentBuildersModule.class})
    abstract MainActivity contributeMainActivity();
}