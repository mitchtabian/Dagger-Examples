package com.codingwithmitch.daggerpractice.ui.main.profile;

import android.util.Log;

import com.codingwithmitch.daggerpractice.AuthSessionManager;
import com.codingwithmitch.daggerpractice.ui.auth.AuthResource;
import com.codingwithmitch.daggerpractice.ui.auth.User;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "DaggerExample";

    private final AuthSessionManager sessionManager;

    @Inject
    public ProfileViewModel(AuthSessionManager sessionManager) {
        this.sessionManager = sessionManager;
        Log.d(TAG, "ProfileViewModel: viewmodel is ready...");
    }

    public LiveData<AuthResource<User>> getAuthenticatedUser(){
        return sessionManager.getAuthUser();
    }
}




















