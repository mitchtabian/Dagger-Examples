package com.codingwithmitch.daggerpractice.ui.main;

import com.codingwithmitch.daggerpractice.di.session.SessionScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @SessionScope
    @Provides
    @Named("main_string")
    static String provideRandomString(){
        return "This is a random string from the MAIN module.";
    }
}
