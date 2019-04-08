package com.codingwithmitch.daggerpractice.ui.auth;

import android.util.Log;

import com.codingwithmitch.daggerpractice.di.SessionManager;
import com.codingwithmitch.daggerpractice.util.Resource;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;


public class AuthViewModel extends ViewModel {

    private static final String TAG = "DaggerExample";

    // inject
    private final SessionManager sessionManager;

    private CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    public AuthViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        Log.d(TAG, "AuthViewModel: viewmodel is working...");
    }


    public void authenticate(int userId){
        Log.d(TAG, "attemptLogin: attempting to login.");
        sessionManager.authenticateWithId(userId);
    }

    public LiveData<AuthResource<User>> observeAuthState(){
        return sessionManager.getAuthUser();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}



















