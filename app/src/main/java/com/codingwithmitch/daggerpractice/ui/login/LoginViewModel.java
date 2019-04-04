package com.codingwithmitch.daggerpractice.ui.login;

import android.util.Log;

import com.codingwithmitch.daggerpractice.ui.main.AuthManager;
import com.codingwithmitch.daggerpractice.util.Resource;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class LoginViewModel extends ViewModel {

    private static final String TAG = "LoginViewModel";

//    private final AuthManager authManager;
    private CompositeDisposable disposables = new CompositeDisposable();
    private MutableLiveData<Resource<User>> authUser = new MutableLiveData<>();

//    @Inject
//    public LoginViewModel(AuthManager authManager) {
//        this.authManager = authManager;
//    }


    @Inject
    public LoginViewModel() {

    }

    public void attemptLogin(int userId){
//        authManager.loginWithUserId(userId)
//                .toObservable()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<User>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "onSubscribe: called.");
//                        disposables.add(d);
//                        authUser.setValue(new Resource<User>(
//                                Resource.Status.LOADING,
//                                null,
//                                ""
//                        ));
//                    }
//
//                    @Override
//                    public void onNext(User user) {
//                        Log.d(TAG, "onNext: " + user.getUsername());
//                        authUser.setValue(Resource.success(user));
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: ", e);
//                        authUser.setValue(new Resource<User>(
//                                Resource.Status.ERROR,
//                                null,
//                                ""
//                        ));
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: called.");
//
//                    }
//                });
    }

    public LiveData<Resource<User>> observeAuthState(){
        return authUser;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
