package com.codingwithmitch.daggerpractice.di.auth;

import com.codingwithmitch.daggerpractice.ui.auth.AuthActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {AuthModule.class, AuthViewModelsModule.class})
@AuthScope
public interface AuthActivitySubcomponent extends AndroidInjector<AuthActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AuthActivity> {}
}