package com.codingwithmitch.daggerpractice.ui.main.profile;

import android.util.Log;

import com.codingwithmitch.daggerpractice.SessionManager;
import com.codingwithmitch.daggerpractice.models.User;
import com.codingwithmitch.daggerpractice.ui.auth.AuthResource;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "DaggerExample";

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        Log.d(TAG, "ProfileViewModel: viewmodel is ready...");
    }

    public LiveData<AuthResource<User>> getAuthenticatedUser(){
        return sessionManager.getAuthUser();
    }
}



















