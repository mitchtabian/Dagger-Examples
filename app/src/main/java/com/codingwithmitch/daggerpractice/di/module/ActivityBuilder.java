package com.codingwithmitch.daggerpractice.di.module;

import com.codingwithmitch.daggerpractice.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}