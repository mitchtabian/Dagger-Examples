package com.codingwithmitch.daggerpractice.di.login;

import com.codingwithmitch.daggerpractice.di.ActivityScope;
import com.codingwithmitch.daggerpractice.di.ViewModelKey;
import com.codingwithmitch.daggerpractice.ui.login.LoginViewModel;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class LoginViewModelsModule {

    @ActivityScope
    @Binds
    @IntoMap // multibinding
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindLoginViewModel(LoginViewModel viewModel);

    @ActivityScope
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);
}
