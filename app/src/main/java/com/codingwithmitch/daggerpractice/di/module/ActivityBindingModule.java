package com.codingwithmitch.daggerpractice.di.module;

import com.codingwithmitch.daggerpractice.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}