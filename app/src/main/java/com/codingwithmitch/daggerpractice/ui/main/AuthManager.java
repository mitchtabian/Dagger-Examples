package com.codingwithmitch.daggerpractice.ui.main;

import android.util.Log;

import com.codingwithmitch.daggerpractice.di.main.MainComponent;
import com.codingwithmitch.daggerpractice.network.users.UsersApi;
import com.codingwithmitch.daggerpractice.ui.login.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class AuthManager {

    private static final String TAG = "AuthManager";

//    private final MainComponent.Builder mainComponentBuilder;
    private MainComponent mainComponent;
    private UsersApi usersApi;

    public MainComponent getMainComponent(){
        return mainComponent;
    }

//    @Inject
//    public AuthManager(UsersApi usersApi, MainComponent.Builder mainComponentBuilder) {
//        this.usersApi = usersApi;
//        this.mainComponentBuilder = mainComponentBuilder;
//    }


//    public AuthManager(UsersApi usersApi, MainComponent.Builder mainComponentBuilder) {
//        this.usersApi = usersApi;
//        this.mainComponentBuilder = mainComponentBuilder;
//    }

    public AuthManager() {

    }

//    public Flowable<User> loginWithUserId(int userId){
//        return usersApi.getUser(userId)
//                .subscribeOn(Schedulers.io())
//                .doOnNext(new Consumer<User>() {
//                    @Override
//                    public void accept(User user) throws Exception {
//                        if(user != null){
//                            createUserSession(user);
//                        }
//                    }
//                })
//                .doOnError(new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Log.e(TAG, "accept: Could not create user session. ", throwable);
//                    }
//                });
//    }

//    private void createUserSession(User user){
//        mainComponent = mainComponentBuilder
//                .user(user)
//                .build();
//    }
}














