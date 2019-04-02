package com.codingwithmitch.daggerpractice.di.module;

import android.app.Application;

import com.codingwithmitch.daggerpractice.persistence.FakeDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    @Singleton
    @Provides
    static FakeDatabase provideFakeDatabase(Application application){
        return new FakeDatabase(application);
    }

}



