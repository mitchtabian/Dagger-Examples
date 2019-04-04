package com.codingwithmitch.daggerpractice.di.main;

import com.codingwithmitch.daggerpractice.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class MainActivityBuildersModule {

    @ContributesAndroidInjector(modules = {MainFragmentBuildersModule.class})
    abstract MainActivity contributeMainActivity();

}