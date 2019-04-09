package com.codingwithmitch.daggerpractice.ui.main;

import com.codingwithmitch.daggerpractice.di.AppComponent;
import com.codingwithmitch.daggerpractice.ui.auth.AuthScope;
import com.codingwithmitch.daggerpractice.ui.auth.User;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @MainScope
    @Provides
    static LinearLayoutManager provideLayoutManager(MainActivity activity) {
        return new LinearLayoutManager(activity);
    }

//    @MainScope
//    @Provides
//    @Named("main_string")
//    static String provideRandomString(){
//        return "This is a random string from the MAIN module.";
//    }


//    @MainScope
//    @Provides
//    @Named("main_string")
//    static String provideAuthUserEmail(User user){
//        return user.getEmail();
//    }

//    @Provides
//    @Named("login_user")
//    static User provideUser(AppComponent appComponent){
//        return appComponent.authSessionManager().getMainComponent().authenticatedUser();
//    }

//    @Provides
//    @Named("login_user")
//    static User provideUser(AppComponent appComponent){
//        return appComponent.authSessionManager().getMainComponent().authenticatedUser();
//    }

//    @Provides
//    @Named("login_user")
//    static User provideUser(User user){
//        return user;
//    }
}



















