package com.codingwithmitch.daggerpractice.ui.auth;


import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthModule {

    @Provides
    @Named("login_user")
    static User provideUser(){
        return new User();
    }

}
