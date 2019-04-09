package com.codingwithmitch.daggerpractice.ui.auth;

import com.codingwithmitch.daggerpractice.AuthSessionManager;
import com.codingwithmitch.daggerpractice.ui.main.MainComponent;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

//@AuthScope
@Subcomponent
//@Subcomponent(modules = {AuthModule.class})
public interface AuthSessionComponent extends AndroidInjector<AuthSessionManager> {

//    MainComponent.Builder mainComponent();

    User getUser();

    @Subcomponent.Builder
    interface Builder{

        AuthSessionComponent build();

        @BindsInstance
        Builder user(User user);
    }
}
