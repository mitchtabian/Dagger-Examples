package com.codingwithmitch.daggerpractice.di.session;

import com.codingwithmitch.daggerpractice.di.SessionManager;
import com.codingwithmitch.daggerpractice.ui.auth.User;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@SessionScope
@Subcomponent
public interface SessionComponent extends AndroidInjector<SessionManager> {

    @Subcomponent.Builder
    interface Builder{

        SessionComponent build();

        @BindsInstance
        Builder user(User user);
    }
}
