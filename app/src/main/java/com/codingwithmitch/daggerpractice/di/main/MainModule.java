package com.codingwithmitch.daggerpractice.di.main;

import com.codingwithmitch.daggerpractice.network.main.MainApi;
import com.codingwithmitch.daggerpractice.ui.main.MainActivity;
import com.codingwithmitch.daggerpractice.ui.main.posts.PostRecyclerAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @MainScope
    @Provides
    static LinearLayoutManager provideLayoutManager(MainActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @MainScope
    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }


    @MainScope
    @Provides
    static PostRecyclerAdapter provideAdapter(){
        return new PostRecyclerAdapter();
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



















