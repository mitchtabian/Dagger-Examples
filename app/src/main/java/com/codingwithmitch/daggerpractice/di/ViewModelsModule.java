package com.codingwithmitch.daggerpractice.di;

import com.codingwithmitch.daggerpractice.ui.auth.AuthViewModel;
import com.codingwithmitch.daggerpractice.ui.main.profile.ProfileViewModel;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


/**
 * Using Multibinding and a custom key to bind all the ViewModel classes to a map
 */
@Module
public abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindLoginViewModel(AuthViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);
}
