package com.codingwithmitch.daggerpractice.di;

import android.util.Log;

import com.codingwithmitch.daggerpractice.di.session.SessionComponent;
import com.codingwithmitch.daggerpractice.network.users.UsersApi;
import com.codingwithmitch.daggerpractice.ui.auth.AuthResource;
import com.codingwithmitch.daggerpractice.ui.auth.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class SessionManager  {

    private static final String TAG = "DaggerExample";

    // inject
    private final UsersApi usersApi;
    private final SessionComponent.Builder sessionComponentBuilder;


    private SessionComponent sessionComponent;
    private MediatorLiveData<AuthResource<User>> cachedUser = new MediatorLiveData<>();

    @Inject
    public SessionManager(UsersApi usersApi, SessionComponent.Builder sessionComponentBuilder) {
        this.usersApi = usersApi;
        this.sessionComponentBuilder = sessionComponentBuilder;
    }

    public void authenticateWithId(final int userId) {
        if(cachedUser != null
                || cachedUser.getValue().data != null
                || cachedUser.getValue().data.getId() != userId){
            cachedUser.setValue(AuthResource.loading((User)null));
            final LiveData<User> source = queryUserId(userId);
            cachedUser.addSource(source, new Observer<User>() {
                @Override
                public void onChanged(User user) {
                    if(user != null){
                        createSession(user);
                    }
                    else{
                        cachedUser.setValue(AuthResource.error("Authentication failed", (User)null));
                    }
                    cachedUser.removeSource(source);
                }
            });
        }
        else{
            Log.d(TAG, "authenticateWithId: previous session detected. Retrieving user from cache.");
        }
    }

    private LiveData<User> queryUserId(int userId){
        return LiveDataReactiveStreams.fromPublisher(usersApi.getUser(userId)
                .subscribeOn(Schedulers.io()));
    }

    private void createSession(User user) {
        sessionComponent = sessionComponentBuilder
                .user(user)
                .build();
        sessionComponent.inject(this);
        cachedUser.setValue(AuthResource.authenticated(user));
    }

    public boolean isLoggedIn() {
        return sessionComponent != null;
    }

    public void logOut() {
        Log.d(TAG, "logOut: logging out...");
        sessionComponent = null;
        cachedUser.setValue(AuthResource.<User>logout());
    }


    public LiveData<AuthResource<User>> getAuthUser(){
        return cachedUser;
    }

}


















