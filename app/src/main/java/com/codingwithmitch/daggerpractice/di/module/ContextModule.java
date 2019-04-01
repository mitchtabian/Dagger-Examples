package com.codingwithmitch.daggerpractice.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Could have included the provideContext method in the AppModule class but it's more efficient
 * to make abstract when possible.
 */
@Module
public abstract class ContextModule {

    @Binds
    abstract Context provideContext(Application application);
}