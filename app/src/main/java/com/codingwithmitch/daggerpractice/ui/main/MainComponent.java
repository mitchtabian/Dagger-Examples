package com.codingwithmitch.daggerpractice.ui.main;

import javax.inject.Singleton;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@MainScope
//@Singleton
@Subcomponent(modules = {
        MainModule.class,
//        MainFragmentBuildersModule.class,
})
public interface MainComponent extends AndroidInjector<MainActivity> {

//    @Subcomponent.Factory
//    interface Factory extends AndroidInjector.Factory<MainActivity>{
//
//    }

    @Subcomponent.Builder
    interface Builder{

        MainComponent build();
    }

}






















