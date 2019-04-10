package com.codingwithmitch.daggerpractice.di.auth;


import com.codingwithmitch.daggerpractice.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class AuthModule {

//    @AuthScope
//    @Provides
//    @Named("login_user")
//    static User provideUser(){
//        return new User();
//    }

//    @Provides
//    @Named("login_user")
//    static User provideUser(User user){
//        return user;
//    }

    @AuthScope
    @Provides
    static AuthApi provideSessionApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }

}



















