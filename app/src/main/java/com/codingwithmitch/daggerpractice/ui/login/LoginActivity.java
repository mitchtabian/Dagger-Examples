package com.codingwithmitch.daggerpractice.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.codingwithmitch.daggerpractice.BaseApplication;
import com.codingwithmitch.daggerpractice.MainActivity;
import com.codingwithmitch.daggerpractice.R;
import com.codingwithmitch.daggerpractice.di.ActivityScope;
import com.codingwithmitch.daggerpractice.di.login.LoginComponent;
import com.codingwithmitch.daggerpractice.util.Resource;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;


import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerAppCompatActivity;

@ActivityScope
public class LoginActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";

    private LoginViewModel viewModel;
    private EditText userId;
    private ProgressBar progressBar;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userId = findViewById(R.id.user_id_input);
        progressBar = findViewById(R.id.progress_bar);

        findViewById(R.id.login_button).setOnClickListener(this);

        viewModel = ViewModelProviders.of(this, providerFactory).get(LoginViewModel.class);

        subscribeObservers();
    }

    private void subscribeObservers(){
        viewModel.observeAuthState().observe(this, new Observer<Resource<User>>() {
            @Override
            public void onChanged(Resource<User> userResource) {
                if(userResource != null){
                    switch (userResource.status){
                        case LOADING:{
                            showProgressBar(true);
                            break;
                        }

                        case SUCCESS:{
                            showProgressBar(false);
                            onLoginSuccess();
                            break;
                        }

                        case ERROR:{
                            showProgressBar(false);
                            break;
                        }
                    }
                }

            }
        });
    }

    private void onLoginSuccess(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void attemptLogin(){
        if (TextUtils.isEmpty(userId.getText().toString())) {
            return;
        }
        viewModel.attemptLogin(Integer.parseInt(userId.getText().toString()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.login_button:{
                attemptLogin();
                break;
            }
        }
    }

    private void showProgressBar(boolean isVisible){
        if(isVisible){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }
}
