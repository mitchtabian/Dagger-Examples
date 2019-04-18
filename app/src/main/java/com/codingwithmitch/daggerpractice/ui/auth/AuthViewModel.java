package com.codingwithmitch.daggerpractice.ui.auth;

import android.util.Log;

import com.codingwithmitch.daggerpractice.models.User;
import com.codingwithmitch.daggerpractice.network.auth.AuthApi;

import org.reactivestreams.Subscription;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: viewmodel is working...");

        authApi.getUser(1)
                .subscribeOn(Schedulers.io())
                .toObservable()
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "onNext: " + user.getEmail());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}














