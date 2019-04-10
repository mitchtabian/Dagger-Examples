package com.codingwithmitch.daggerpractice.di.auth;

import com.codingwithmitch.daggerpractice.di.ViewModelKey;
import com.codingwithmitch.daggerpractice.ui.auth.AuthViewModel;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);
}
