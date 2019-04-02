package com.codingwithmitch.daggerpractice.di.module;

import com.codingwithmitch.daggerpractice.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {FragmentBuilder.class})
    abstract MainActivity contributeMainActivity();

}