package com.codingwithmitch.daggerpractice.di;

import com.codingwithmitch.daggerpractice.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeMainActivity();


    @Provides
    static String someString(){
        return "this is a test string";
    }
}
