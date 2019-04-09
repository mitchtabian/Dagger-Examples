package com.codingwithmitch.daggerpractice.di;


import com.codingwithmitch.daggerpractice.BaseActivity;
import com.codingwithmitch.daggerpractice.ui.auth.AuthModule;
import com.codingwithmitch.daggerpractice.ui.auth.AuthActivity;
import com.codingwithmitch.daggerpractice.ui.auth.AuthScope;
import com.codingwithmitch.daggerpractice.ui.main.MainActivity;
import com.codingwithmitch.daggerpractice.ui.main.MainComponent;
import com.codingwithmitch.daggerpractice.ui.main.MainFragmentBuildersModule;
import com.codingwithmitch.daggerpractice.ui.main.MainModule;
import com.codingwithmitch.daggerpractice.ui.main.MainScope;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
        subcomponents = {
                MainComponent.class
        })
//@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?> bindMainActivityInjectorFactory(MainComponent.Factory factory);

//    @MainScope
//    @ContributesAndroidInjector(modules = {MainModule.class, MainFragmentBuildersModule.class})
//    abstract MainActivity contributeMainActivity();
}
