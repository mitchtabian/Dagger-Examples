package com.codingwithmitch.daggerpractice.di;

import com.codingwithmitch.daggerpractice.ui.auth.AuthViewModel;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class ViewModelsModule {

    @Binds
    @IntoMap // multibinding
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindLoginViewModel(AuthViewModel viewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);
}
